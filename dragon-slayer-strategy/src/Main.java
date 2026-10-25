import java.util.List;

import model.CharacterStats;
import model.Enemy;
import model.GameCharacter;
import strategy.ArrowVolley;
import strategy.AttackStrategy;
import strategy.FireballSpell;
import strategy.ShadowBackstab;
import strategy.ShieldBash;
import strategy.SwordSlash;

/**
 * Client of the Strategy pattern.
 * It chooses which strategies exist and in which order the hero uses them.
 * All strategy selection happens here, none of it inside GameCharacter.
 */
public class Main {

    public static void main(String[] args) {
        GameCharacter hero = new GameCharacter(
                "Aria the Versatile",
                new CharacterStats(18, 22, 25, 15),
                new SwordSlash());

        Enemy dragon = new Enemy("Ancient Dragon", 400, 12, 15);

        List<AttackStrategy> battlePlan = List.of(
                new SwordSlash(),
                new FireballSpell(),
                new ArrowVolley(),
                new ShadowBackstab(),
                new ShieldBash());

        System.out.println(hero.getName() + " enters the lair of the " + dragon.getName()
                + " (HP " + dragon.getHealth() + ")");
        System.out.println();

        int round = 0;
        while (dragon.isAlive()) {
            AttackStrategy chosenStyle = battlePlan.get(round % battlePlan.size());
            hero.setAttackStrategy(chosenStyle);

            int damage = hero.attack(dragon);
            round++;

            System.out.println("Round " + round + ": " + hero.getName() + " uses "
                    + hero.getCurrentAttackName() + " -> " + damage + " damage. "
                    + dragon.getName() + " HP: " + dragon.getHealth());
        }

        System.out.println();
        System.out.println("The " + dragon.getName() + " is defeated after " + round + " rounds!");
    }
}
