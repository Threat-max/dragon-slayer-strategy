package strategy;

import model.CharacterStats;
import model.Enemy;

/** Rogue style: strikes weak spots, so enemy armor and magic resistance are both ignored. */
public class ShadowBackstab implements AttackStrategy {

    private static final int DEXTERITY_MULTIPLIER = 4;

    @Override
    public String getName() {
        return "Shadow Backstab";
    }

    @Override
    public int calculateDamage(CharacterStats attackerStats, Enemy target) {
        return attackerStats.getDexterity() * DEXTERITY_MULTIPLIER;
    }
}
