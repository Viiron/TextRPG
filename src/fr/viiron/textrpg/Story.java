package fr.viiron.textrpg;

public class Story {
    public static void printIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("HISTOIRE");
        GameLogic.printSeparator(30);
        System.out.println("Vous êtes le dernier survivant après que votre village ait été attaquer par les hommes de l'empereur maléfique.");
        System.out.println("Tous vos amis, vos voisins et votre famille ont été tuer. Vous êtes le seul survivant parmi ces ruines enflammées");
        System.out.println("Maintenant, vous voulez vous venger, donc vous votre voyage pour battre l'empereur maléfique et retrouver vos terres !");
        GameLogic.anythingToContinue();
    }

    public static void printFirstActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT I - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("Au début de votre voyage, vous commencez à traverser les bois voisins pour atteindre les montagnes éternelles.");
        System.out.println("Les montagnes éternelles sont un endroit très dangereux. Il dit que personne n'est revenu vivant de là-bas.");
        System.out.println("\nAprès une longue journée de marche à travers les bois, vous atteignez enfin les montagnes éternelles");
        System.out.println("Vous ne vous souciez pas des choses que vous avez entendues sur cet endroit dangereux et commencez votre voyage pour vaincre l'empereur maléfique");
        GameLogic.anythingToContinue();
    }

    public static void printFirstActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT I - OUTRO");
        GameLogic.printSeparator(30);
        System.out.println("Vous l'avais fait ! Vous avez traversé les montagnes éternelles et vous êtes toujours en vie !");
        System.out.println("Alors que vous descendez la dernière colline, vous êtes plus qu'heureux de sentir à nouveau un sol dur sous vos pieds.");
        System.out.println("\nVous vous sentez mieux et l'expérience que vous avez acquise vous permet d'améliorer une compétence !");
        GameLogic.anythingToContinue();
    }

    public static void printSecondActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT II - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("Vous commencez à voyager à travers les routes de cette campagne autrefois bien peuplée.");
        System.out.println("Vous avez récupéré de l'or sur les monstres que vous avez tués en chemin.");
        System.out.println("Heureusement, vous savez que de temps en temps un commerçant ambulant rencontre ces routes.");
        System.out.println("Vous savez exactement où se trouve le château de l'empereur maléfique, mais vous devez d'abord traverser ces routes hantées...");
        GameLogic.anythingToContinue();
    }

    public static void printSecondActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT II - OUTRO");
        GameLogic.printSeparator(30);
        System.out.println("Vous avez réussi à traverser ces routes hantées et vous êtes toujours en vie !.");
        System.out.println("Vous n'êtes qu'à quelques heures de votre destination finale ; le château de l'empereur maléfique.");
        System.out.println("Vous savez que vous ne pouvez probablement pas vous reposer là-bas, alors vous faites une dernière pause pour retrouver un peu de vie..");
        System.out.println("\nVous vous sentez mieux et l'expérience que vous avez acquise vous permet d'améliorer une compétence !");
        GameLogic.anythingToContinue();
    }

    public static void printThirdActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT III - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("Vous voyez l'immense château noir devant vous.");
        System.out.println("Alors que vous vous tenez devant les portes, vous savez qu'il n'y a pas de retour en arrière");
        System.out.println("Vous êtes déguisé en mercenaire et entrez dans le château. Vous ne savez pas combien de temps il vous reste avant que quelqu'un vous distingue.");
        System.out.println("Tout ce que vous pouvez faire, c'est lutter pour votre vie et prier pour sortir vainqueur...");
        GameLogic.anythingToContinue();
    }

    public static void printThirdActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT III - OUTRO");
        GameLogic.printSeparator(30);
        System.out.println("Vous êtes venu de si loin. Vous avez vaincu tous les serviteurs de l'Empereur maléfique..");
        System.out.println("Alors que vous vous tenez devant la porte de sa salle du trône, vous savez qu'il n'y a pas de retour en arrière.");
        System.out.println("Vous vous souvenez de votre compétence perdu et restaurez votre vie.");
        System.out.println("Vous avez la chance d'améliorer une dernière fois une compétence avant d'entrer dans la salle du trône");
        GameLogic.anythingToContinue();
    }

    public static void printFourthActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("ACT IV - INTRO");
        GameLogic.printSeparator(30);
        System.out.println("Vous entrez dans la salle du trône de l'empereur maléfique.");
        System.out.println("Vous vous regarder droit dans les yeux. Vous sentez l'obscurité autour de toi.");
        System.out.println("Il sort l'épée sacrée des ténèbres, l'arme la plus puissante connue de l'homme.");
        System.out.println("Tout ce que vous pouvez faire, c'est lutter pour votre vie et prier pour sortir vainqueur...\n");
        GameLogic.anythingToContinue();
    }

    public static void printEnd(Player player){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Félicitations, " + player.name + " ! Vous avez battu l'Empereur maléfique et sauver le monde !");
        GameLogic.printSeparator(30);
        System.out.println("Ce jeu a été créer par Viiron.");
        System.out.println("J'espère que le jeu vous a plu !");
        GameLogic.anythingToContinue();
    }
}
