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
public class DamageMonsterWithDice extends Effect<Player, List<Monster>> {

    private final int damageFactor;
    private int level;

    public DamageMonsterWithDice(int damageFactor, int level ) {
        this.damageFactor = damageFactor;

        this.level = level;
    }

    @Override
    public void applyEffect(final Player aggressor, final List<Monster> targets) {
        Monster target = getTargetMonster(aggressor, targets);
        int dice = aggressor.getRoll();
        var effect = new DamageMonster(
                new Damage(DamageType.PHYSICAL,
                        damageFactor * level + dice));
        effect.applyEffect(aggressor, target);
        target.resetFocus();
    }

}
