package fr.viiron.textrpg;

public abstract class Character {

    //Variables / Attribus de tout les characters
    public String name;
    public int maxHp, hp, xp;

    //Constructeur du Character
    public Character(String name, int maxHp, int xp) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.xp = xp;
    }

    public abstract int attack();
    public abstract int defend();
}
