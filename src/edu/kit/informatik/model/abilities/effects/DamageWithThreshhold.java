package edu.kit.informatik.model.abilities.effects;

import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.Cards.DamageType;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-17
 */
public class DamageWithThreshhold extends Effect<Player, List<Monster>> {

    private int bonusThreshhold;
    private int damageFactor;
    private int bonusFactor;
    private int level;

    public DamageWithThreshhold(int bonusThreshhold, int damageFactor, int bonusFactor, int level) {
        this.bonusThreshhold = bonusThreshhold;
        this.damageFactor = damageFactor;
        this.bonusFactor = bonusFactor;
        this.level = level;
    }

    @Override
    public void applyEffect(final Player aggressor, final List<Monster> targets) {
        Monster target = getTargetMonster(aggressor, targets);
        int dice = aggressor.getRoll(); //might also make this as effect
        int damageAmount = damageFactor * level + dice;
        if (dice > bonusThreshhold) {
            damageAmount += bonusFactor * level;
        }
        var effect = new DamageMonster(new Damage(DamageType.PHYSICAL, damageAmount));
        effect.applyEffect(aggressor, target);
    }
}
