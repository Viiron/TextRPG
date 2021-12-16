package fr.viiron.textrpg;

public class Player extends Character {

    //integers pour avoir le nombre de compétences acquises
    public int numAtkUpgrades, numDefUpgrades;

    int gold, restsLeft, pots;

    //Stocker les nom des compétences
    public String[] atkUpgrades = {"Force", "Force II", "Force III", "Force divine"};
    public String[] defUpgrades = {"Résistance", "Résistance II", "Résistance III", "Aura sacrée"};

    // Constructeur du joueur
    public Player(String name) {
        super(name, 100, 0);

        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;

        this.gold = 5;
        this.restsLeft = 1;
        this.pots = 0;

        chooseTrait();
    }

    // Méthodes du joueur
    @Override
    public int attack() {
        return (int) (Math.random()*(xp/4 + numAtkUpgrades * 3 + 3) + xp/10 + numAtkUpgrades*2 + numDefUpgrades + 1);
    }

    @Override
    public int defend() {
        return (int) (Math.random()*(xp/4 + numDefUpgrades * 3 + 3) + xp/10 + numDefUpgrades*2 + numAtkUpgrades + 1);
    }

    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Choisisez une compétence à améliorer:");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);

        int input = GameLogic.readInt("-> ", 2);
        GameLogic.clearConsole();

        if(input == 1){
            GameLogic.printHeading("Vous avez choisi: " + atkUpgrades[numAtkUpgrades]);
            numAtkUpgrades++;
        } else {
            GameLogic.printHeading("Vous avez choisi: " + defUpgrades[numDefUpgrades]);
            numDefUpgrades++;
        }
        GameLogic.anythingToContinue();
    }
}
