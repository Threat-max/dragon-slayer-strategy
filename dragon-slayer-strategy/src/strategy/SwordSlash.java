package strategy;

import model.CharacterStats;
import model.Enemy;

/** Warrior style: heavy hit powered by strength, reduced by enemy armor. */
public class SwordSlash implements AttackStrategy {

    private static final int STRENGTH_MULTIPLIER = 3;

    @Override
    public String getName() {
        return "Sword Slash";
    }

    @Override
    public int calculateDamage(CharacterStats attackerStats, Enemy target) {
        int rawDamage = attackerStats.getStrength() * STRENGTH_MULTIPLIER;
        return DamageMath.afterResistance(rawDamage, target.getArmor());
    }
}
