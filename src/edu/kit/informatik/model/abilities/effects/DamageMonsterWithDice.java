package edu.kit.informatik.model.abilities.effects;

import edu.kit.informatik.model.Cards.DamageType;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Damage;

/**
 * The type Damage monster with dice.
 *
 * @author upkim
 * @version 1.0.0 2022-03-17
 */
public class DamageMonsterWithDice extends Effect<Player, Monster> {

    private final int damageFactor;
    private final int level;
    private final int roll;

    /**
     * Instantiates a new Damage monster with dice.
     *
     * @param damageFactor the damage factor
     * @param level        the level
     * @param roll         the roll
     */
    public DamageMonsterWithDice(int damageFactor, int level, int roll) {
        this.damageFactor = damageFactor;
        this.level = level;
        this.roll = roll;
    }

    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        var effect = new DamageMonster(new Damage(DamageType.PHYSICAL, damageFactor * level + roll));
        effect.applyEffect(aggressor, target);
        target.resetFocus();
    }
}
