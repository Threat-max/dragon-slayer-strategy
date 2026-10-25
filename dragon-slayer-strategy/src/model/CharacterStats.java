package model;

/** Immutable set of attributes that attack strategies read from. */
public class CharacterStats {

    private final int strength;
    private final int dexterity;
    private final int intelligence;
    private final int defense;

    public CharacterStats(int strength, int dexterity, int intelligence, int defense) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.defense = defense;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getDefense() {
        return defense;
    }
}
