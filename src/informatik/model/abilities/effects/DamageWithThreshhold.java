package informatik.model.abilities.effects;

import edu.kit.informatik.model.Cards.DamageType;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Damage;

/**
 * The Damage with threshhold class is best characterized through its damage formula. It applies damageFactor * level +
 * dice roll damage and additional bonusfactor * level damage, if the dice roll exceeds the bonus threshold.
 *
 * @author upkim
 * @version 1.0.0 2022-03-17
 */
public class DamageWithThreshhold extends Effect<Player, Monster> {

    private final int bonusThreshhold;
    private final int damageFactor;
    private final int bonusFactor;
    private final int level;
    private final int diceRoll;

    /**
     * Instantiates a new Damage with threshhold.
     *
     * @param bonusThreshhold the bonus threshhold
     * @param damageFactor    the damage factor
     * @param bonusFactor     the bonus factor
     * @param level           the level
     * @param diceRoll        the dice roll
     */
    public DamageWithThreshhold(int bonusThreshhold, int damageFactor, int bonusFactor, int level, final int diceRoll) {
        this.bonusThreshhold = bonusThreshhold;
        this.damageFactor = damageFactor;
        this.bonusFactor = bonusFactor;
        this.level = level;
        this.diceRoll = diceRoll;
    }

    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        int damageAmount = damageFactor * level + diceRoll;
        if (diceRoll >= bonusThreshhold) {
            damageAmount += bonusFactor * level;
        }
        var effect = new DamageMonster(new Damage(DamageType.PHYSICAL, damageAmount));
        effect.applyEffect(aggressor, target);
    }
}
