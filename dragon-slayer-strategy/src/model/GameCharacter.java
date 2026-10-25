package model;

import java.util.Objects;

import strategy.AttackStrategy;

/**
 * Context of the Strategy pattern.
 * Holds a reference to the current AttackStrategy and delegates the attack to it.
 * It has no idea which concrete strategy it is using, and the strategy can be swapped at runtime.
 */
public class GameCharacter {

    private final String name;
    private final CharacterStats stats;
    private AttackStrategy attackStrategy;

    public GameCharacter(String name, CharacterStats stats, AttackStrategy startingStrategy) {
        this.name = name;
        this.stats = stats;
        this.attackStrategy = Objects.requireNonNull(startingStrategy);
    }

    /** Runtime switching of the combat style. */
    public void setAttackStrategy(AttackStrategy newStrategy) {
        this.attackStrategy = Objects.requireNonNull(newStrategy);
    }

    /** Delegates the damage calculation to the current strategy and applies the result. */
    public int attack(Enemy target) {
        int damage = attackStrategy.calculateDamage(stats, target);
        target.takeDamage(damage);
        return damage;
    }

    public String getName() {
        return name;
    }

    public String getCurrentAttackName() {
        return attackStrategy.getName();
    }
}
