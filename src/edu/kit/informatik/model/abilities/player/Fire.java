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
public class Fire extends Ability<Player, Monster> {

    private static final int DAMAGE_FACTOR = 2;
    private static final int DAMAGE_CONSTANT = 5;
    private static final int SECOND_DAMAGE_CONSTANT = 0;
    private static final int BONUS_DAMAGE_FACTOR = 2;

    public Fire(final String name, final int level) {
        super(name, level, AbilityType.OFFENSIV);
    }

    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        var effect = new ElementPlayerEffect(MonsterType.ICE, DAMAGE_FACTOR, DAMAGE_CONSTANT, SECOND_DAMAGE_CONSTANT,
                BONUS_DAMAGE_FACTOR, level);
    }
}


