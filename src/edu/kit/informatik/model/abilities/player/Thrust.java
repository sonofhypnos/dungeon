package edu.kit.informatik.model.abilities.player;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.abilities.effects.DamageWithThreshhold;
import edu.kit.informatik.ui.prompts.Prompt;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Thrust extends Ability<Player, Monster> {

    public Thrust(final String thrust, final int level) {
        super(thrust, level, AbilityType.OFFENSIV);
        this.type = AbilityType.OFFENSIV;
    }

    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        var effect = new DamageWithThreshhold(6, 6, 4, this.level, this.getRoll());
        effect.applyEffect(aggressor, target);
        // TODO: 17.03.22 handle isDead in another place
    }
}
