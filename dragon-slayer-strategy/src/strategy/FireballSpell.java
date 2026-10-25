package strategy;

import model.CharacterStats;
import model.Enemy;

/** Mage style: huge hit powered by intelligence, reduced by magic resistance (armor is ignored). */
public class FireballSpell implements AttackStrategy {

    private static final int INTELLIGENCE_MULTIPLIER = 4;

    @Override
    public String getName() {
        return "Fireball Spell";
    }

    @Override
    public int calculateDamage(CharacterStats attackerStats, Enemy target) {
        int rawDamage = attackerStats.getIntelligence() * INTELLIGENCE_MULTIPLIER;
        return DamageMath.afterResistance(rawDamage, target.getMagicResistance());
    }
}
