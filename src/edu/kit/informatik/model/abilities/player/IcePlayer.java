package edu.kit.informatik.model.abilities.player;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.MonsterType;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.abilities.effects.ElementPlayerEffect;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class IcePlayer extends Ability<Player, List<Monster>> {

    public IcePlayer(final String name, final int level) {
        super(name, level, AbilityType.OFFENSIV);
    }

    @Override
    public void applyEffect(final Player aggressor, final List<Monster> targets) {
        var effect = new ElementPlayerEffect(MonsterType.WATER, 2, 4, 2, 2, level);
        effect.applyEffect(aggressor, targets);
    }
}
