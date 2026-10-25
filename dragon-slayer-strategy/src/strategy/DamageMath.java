package strategy;

/**
 * Small helper shared by the strategies so the "never below minimum damage"
 * rule lives in exactly one place (DRY).
 */
final class DamageMath {

    private static final int MINIMUM_DAMAGE = 1;

    private DamageMath() {
    }

    /** Subtracts the enemy's resistance from raw damage, but never goes below the minimum. */
    static int afterResistance(int rawDamage, int resistance) {
        return Math.max(MINIMUM_DAMAGE, rawDamage - resistance);
    }
}
