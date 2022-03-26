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
public class DamageMonsterWithDice extends Effect<Player, Monster> {

    private final int damageFactor;
    private int level;
    private int roll;

    public DamageMonsterWithDice(int damageFactor, int level, int roll) {
        this.damageFactor = damageFactor;
        this.level = level;
        this.roll = roll;
    }

    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        var effect = new DamageMonster(new Damage(DamageType.PHYSICAL,
                        damageFactor * level + roll));
        effect.applyEffect(aggressor, target);
        target.resetFocus();
    }
}
