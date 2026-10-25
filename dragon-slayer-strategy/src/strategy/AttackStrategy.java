package strategy;

import model.CharacterStats;
import model.Enemy;

/**
 * Strategy interface: one combat style = one way of calculating damage.
 * Every concrete attack in the game implements this single method set.
 */
public interface AttackStrategy {

    /** Name shown in the battle log, e.g. "Fireball Spell". */
    String getName();

    /** Calculates how much damage this attack deals to the given enemy. */
    int calculateDamage(CharacterStats attackerStats, Enemy target);
}
