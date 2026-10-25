package strategy;

import model.CharacterStats;
import model.Enemy;

/** Archer style: several arrows, each one reduced by armor separately. */
public class ArrowVolley implements AttackStrategy {

    private static final int ARROWS_PER_VOLLEY = 3;
    private static final int DEXTERITY_MULTIPLIER = 2;

    @Override
    public String getName() {
        return "Arrow Volley";
    }

    @Override
    public int calculateDamage(CharacterStats attackerStats, Enemy target) {
        int rawDamagePerArrow = attackerStats.getDexterity() * DEXTERITY_MULTIPLIER;
        int damagePerArrow = DamageMath.afterResistance(rawDamagePerArrow, target.getArmor());
        return damagePerArrow * ARROWS_PER_VOLLEY;
    }
}
