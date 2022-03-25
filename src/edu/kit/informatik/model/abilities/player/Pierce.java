package edu.kit.informatik.model.abilities.player;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.abilities.effects.DamageWithThreshhold;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Pierce extends Ability<Player, Monster> {

    private static final int BONUS_THRESHHOLD = 6;
    private static final int DAMAGE_FACTOR = 6;
    private static final int BONUS_FACTOR = 4;

    public Pierce(final String name, final int level) {
        super(name, level, AbilityType.OFFENSIV);
    }

    public void applyEffect(final Player aggressor, final Monster target) {
        var effect = new DamageWithThreshhold(BONUS_THRESHHOLD, DAMAGE_FACTOR, BONUS_FACTOR, this.level);
        effect.applyEffect(aggressor, target);
    }
}
