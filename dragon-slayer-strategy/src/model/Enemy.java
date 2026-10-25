package model;

/** A monster the hero fights. Knows nothing about attack strategies. */
public class Enemy {

    private final String name;
    private final int armor;
    private final int magicResistance;
    private int health;

    public Enemy(String name, int health, int armor, int magicResistance) {
        this.name = name;
        this.health = health;
        this.armor = armor;
        this.magicResistance = magicResistance;
    }

    public void takeDamage(int damage) {
        health = Math.max(0, health - damage);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }

    public int getMagicResistance() {
        return magicResistance;
    }
}
