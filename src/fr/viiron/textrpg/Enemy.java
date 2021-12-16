package fr.viiron.textrpg;

public class Enemy extends Character{

    int playerxp;

    public Enemy(String name, int playerxp) {
        super(name, (int) (Math.random()*playerxp/3 + 5), (int) (Math.random()*(playerxp/4 + 2) + 1));
        this.playerxp = playerxp;
    }

    @Override
    public int attack() {
        return (int) (Math.random()*(playerxp/4 + 1) + xp/4 + 3);
    }

    @Override
    public int defend() {
        return (int) (Math.random()*(playerxp/4 + 1) + xp/4 + 3);
    }
}
