package fr.viiron.textrpg;

import java.util.Scanner;

public class GameLogic {
    public static Scanner scanner = new Scanner(System.in);

    public static Player player;

    public static boolean isRunning;

    public static String[] encounters = {"Combat", "Combat", "Combat", "Repos", "Repos"};

    public static String[] enemies = {"Ogre", "Ogre", "Gobelin", "Gobelin", "Homme de pierre"};

    // Elements d'histoire
    public static int place = 0, act = 1;
    public static String[] places = {"Montagnes éternelles", "Routes Hantées", "Château de l'Empereur maléfique", "Salle du throne"};

    // méthode pour avoir le chiffre qui a été mis dans la console
    public static int readInt(String prompt, int userChoices){
        int input;

        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            }catch (Exception e){
                input = - 1;
                System.out.println("Veuillez entrer un nombre !");
            }
        }while(input < 1 || input > userChoices);

        return input;
    }

    //méthode pour clear la console
    public static void clearConsole(){
        for(int i = 0; i < 100; i++){
            System.out.println();
        }
    }

    //méthode pour envoyer un séparateur x fois
    public static void printSeparator(int x){
        for(int i = 0; i < x; i++){ System.out.print("-"); }
        System.out.println();
    }

    //méthode pour envoyer un "titre"
    public static void printHeading(String title){
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    //méthode pour arreter le jeu quand un joueur entre quelque chose
    public static void anythingToContinue(){
        System.out.println("\nEntrez quelque chose pour continuer...");
        scanner.next();
    }

    //méthode pour commencer le jeu
    public static void startGame(){
        boolean nameSet = false;
        String name;
        clearConsole();
        printSeparator(40);
        printSeparator(40);
        System.out.println("TEXT RPG PAR VIIRON");
        printSeparator(40);
        printSeparator(40);
        anythingToContinue();

        do{
            clearConsole();
            printHeading("Quel est ton nom ?");
            name = scanner.next();

            clearConsole();
            printHeading("Votre nom est bien " + name + ".\nC'est bien cela ?");
            System.out.println("(1) Oui !");
            System.out.println("(2) Non, c'est nul.");
            int input = readInt("-> ", 2);
            if(input == 1) nameSet = true;
        }while(!nameSet);

        // Print l'intro
        Story.printIntro();

        // Créer un nouveau joueur avec le nom choisit
        player = new Player(name);

        // Print le début
        Story.printFirstActIntro();

        isRunning = true;

        gameLoop();
    }

    public static void checkAct(){
        if(player.xp >= 10 && act == 1){
            act = 2;
            place = 1;

            Story.printFirstActOutro();

            player.chooseTrait();

            Story.printSecondActIntro();

            enemies[0] = "Mercenaire maléfique";
            enemies[1] = "Gobelin";
            enemies[2] = "Loup-Garou";
            enemies[3] = "Esclave de l'Empereur maléfique";
            enemies[4] = "Mercenaire maléfique";

            encounters[0] = "Combat";
            encounters[1] = "Combat";
            encounters[2] = "Combat";
            encounters[3] = "Repos";
            encounters[4] = "Boutique";
        } else if (player.xp >= 50 && act == 2){
            act = 3;
            place = 2;

            Story.printSecondActOutro();

            player.chooseTrait();

            Story.printThirdActIntro();

            enemies[0] = "Mercenaire maléfique";
            enemies[1] = "Mercenaire maléfique";
            enemies[2] = "Esclave de l'Empereur maléfique";
            enemies[3] = "Esclave de l'Empereur maléfique";
            enemies[4] = "Esclave de l'Empereur maléfique";

            encounters[0] = "Combat";
            encounters[1] = "Combat";
            encounters[2] = "Combat";
            encounters[3] = "Combat";
            encounters[4] = "Boutique";

            player.hp = player.maxHp;
        } else if (player.xp >= 100 && act == 3){
            act = 4;
            place = 3;

            Story.printThirdActOutro();

            player.chooseTrait();
            player.hp = player.maxHp;
            finalBattle();
        }
    }

    public static void randomEncounter(){
        int encounter = (int) (Math.random() * encounters.length);
        if(encounters[encounter].equals("Combat")){
            randomBattle();
        } else if(encounters[encounter].equals("Repos")){
            takeRest();
        } else {
            shop();
        }
    }

    public static void continueJourney(){
        //regarder ou en est le joueur
        checkAct();
        // si le jeu n'est pas le dernier act
        if(act != 4) randomEncounter();
    }

    public static void characterInfo(){
        clearConsole();
        printHeading("INFORMATIONS");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeparator(20);
        System.out.println("XP: " + player.xp + "\tOr: " + player.gold);
        printSeparator(20);
        System.out.println("Nombre de potions: " + player.pots);
        printSeparator(20);

        if(player.numAtkUpgrades > 0){
            System.out.println("Attaque: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeparator(20);
        }

        if(player.numDefUpgrades > 0){
            System.out.println("Défense: " + player.defUpgrades[player.numDefUpgrades - 1]);
            printSeparator(20);
        }

        anythingToContinue();
    }

    public static void shop(){
        clearConsole();
        printHeading("Vous avez rencontré un homme mystérieux...\nIl a une offre pour vous:");
        int price = (int) (Math.random()* (10 + player.pots*3) + 10 + player.pots);
        System.out.println("- Potion magique: " + price + " or.");
        printSeparator(20);
        System.out.println("Voulez-vous en acheter une ?\n(1) Oui !\n(2) Non merci.");
        int input = readInt("-> ", 2);
        if(input == 1){
            clearConsole();
            if(player.gold >= price){
                printHeading("Vous avez acheter une potion magique pour " + price + " or.");
                player.pots++;
                player.gold -= price;
            } else {
                printHeading("Vous n'avez pas assez d'or pour acheter ça.");
            }
            anythingToContinue();
        }
    }

    public static void takeRest(){
        clearConsole();
        if(player.restsLeft >= 1){
            printHeading("Voulez prendre du repos ? (" + player.restsLeft + " repos restants).");
            System.out.println("(1) Oui\n(2) Non");
            int input = readInt("-> ", 2);
            if(input == 1){
                clearConsole();
                if(player.hp < player.maxHp){
                    int hpRestored = (int) (Math.random() * (player.xp/4 + 1) + 10);
                    player.hp += hpRestored;
                    if(player.hp > player.maxHp){
                        player.hp = player.maxHp;
                    }
                    System.out.println("Vous avez pris une pause et avez récupéré " + hpRestored + " hp.");
                    System.out.println("Vous êtes désormais à " + player.hp + "/" + player.maxHp + " hp.");
                    player.restsLeft--;
                }
            } else {
                System.out.println("Vous avez toutes votre vie. Vous n'avez pas besoin de repos !");
            }
            anythingToContinue();
        }
    }

    public static void randomBattle(){
        clearConsole();
        printHeading("Vous venez de rencontrer une créature maléfique. Vous devez la battre !");
        anythingToContinue();

        battle(new Enemy(enemies[(int)(Math.random()* enemies.length)], player.xp));
    }

    public static void battle(Enemy enemy){
        while(true){
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
            System.out.println("Choisissez une action:");
            printSeparator(20);
            System.out.println("(1) Combattre\n(2) Utiliser une potion\n(3) Fuir");
            int input = readInt("-> ", 3);
            if(input == 1){
                // Bataille
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();
                if(dmgTook < 0){
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }
                if(dmg < 0){
                    dmg = 0;
                }
                player.hp -= dmgTook;
                enemy.hp -= dmg;
                clearConsole();
                printHeading("BATAILLE");
                System.out.println("Vous avez retiré " + dmg + " hp à " + enemy.name + ".");
                printSeparator(15);
                System.out.println(enemy.name + " vous a retiré " + dmgTook + " hp.");
                anythingToContinue();

                if(player.hp <= 0){
                    playerDied();
                    break;
                } else if(enemy.hp <= 0){
                    clearConsole();
                    printHeading("Vous avez battu " + enemy.name + " !");
                    player.xp += enemy.xp;
                    System.out.println("Vous avez gagné " + enemy.xp + " !");
                    int goldEarned = (int) (Math.random()*enemy.xp);
                    boolean addRest = (Math.random()*5 + 1 <= 2.25);
                    if(addRest){
                        player.restsLeft++;
                        System.out.println("Vous avez eu la chance d'avoir du repos en plus !");
                    }
                    if(goldEarned > 0){
                        player.gold += goldEarned;
                        System.out.println("Vous avez collecté " + goldEarned + " or sur le corps de " + enemy.name);
                    }
                    anythingToContinue();
                    break;
                }
            } else if(input == 2){
                clearConsole();
                if(player.pots > 0 && player.hp < player.maxHp){
                    printHeading("Voulez-vous boire une potion ? (" + player.pots + " restant).");
                    System.out.println("(1) Oui\n(2) Non, peut être plus tard");
                    input = readInt("-> ", 2);
                    if(input == 1){
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("Vous avez bu une potion magique ! Votre vie est repassé à " + player.maxHp);
                        anythingToContinue();
                    }
                } else{
                    printHeading("Vous n'avez pas de potion ou vous avez toute votre vie.");

                }
            } else {
                clearConsole();
                if (act != 4) {
                    if (Math.random() * 10 + 1 <= 3.5) {
                        printHeading("Vous avez fuis le combat !");
                        anythingToContinue();
                        break;
                    } else {
                        printHeading("Vous n'avez pas réussi à vous enfuire !");
                        int dmgTook = enemy.attack();
                        System.out.println("A cause de votre fuite, vous avez perdu " + dmgTook + " hp !");
                        anythingToContinue();
                        if (player.hp <= 0) {
                            playerDied();
                        }
                    }
                } else {
                    printHeading("VOUS NE POUVEZ PAS VOUS ENFUIR DE L'EMPEREUR MALEFIQUE !!!");
                    anythingToContinue();
                }
            }
        }
    }

    public static void printMenu(){
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choisissez une action:");
        printSeparator(20);
        System.out.println("(1) Continuer sur votre partie");
        System.out.println("(2) Informations sur votre joueur");
        System.out.println("(3) Quitter le jeu");
    }

    public static void playerDied(){
        clearConsole();
        printHeading("Vous êtes mort...");
        printHeading("Vous avez gagné " + player.xp + " XP dans votre voyage. Essayer d'en avoir + la prochaine fois !");
        isRunning = false;
    }

    public static void finalBattle(){
        battle(new Enemy("L'EMPEREUR MALEFIQUE", 300));
        Story.printEnd(player);
        isRunning = false;
    }

    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt("-> ", 3);
            if(input == 1){
                continueJourney();
            } else if(input == 2){
                characterInfo();
            } else {
                isRunning = false;
            }
        }
    }
}
