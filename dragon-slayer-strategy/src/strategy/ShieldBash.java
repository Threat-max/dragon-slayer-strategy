package strategy;

import model.CharacterStats;
import model.Enemy;

/**
 * Paladin style: damage comes mostly from defense.
 * Added last to prove the pattern is extensible - no existing class was changed.
 */
public class ShieldBash implements AttackStrategy {

    private static final int DEFENSE_MULTIPLIER = 3;

    @Override
    public String getName() {
        return "Shield Bash";
    }

    @Override
    public int calculateDamage(CharacterStats attackerStats, Enemy target) {
        int rawDamage = attackerStats.getDefense() * DEFENSE_MULTIPLIER + attackerStats.getStrength();
        return DamageMath.afterResistance(rawDamage, target.getArmor());
    }
}
