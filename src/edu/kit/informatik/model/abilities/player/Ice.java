package edu.kit.informatik.model.abilities.player;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.MonsterType;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.abilities.effects.ElementPlayerEffect;

/**
 * The type Ice.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Ice extends Ability<Player, Monster> {

    private static final int DAMAGE_FACTOR = 2;
    private static final int DAMAGE_CONSTANT = 4;
    private static final int SECOND_DAMAGE_CONSTANT = 2;
    private static final int BONUS_DAMAGE_FACTOR = 2;

    /**
     * Instantiates a new Ice.
     *
     * @param name  the name
     * @param level the level
     */
    public Ice(final String name, final int level) {
        super(name, level, AbilityType.OFFENSIVE);
    }

    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        var effect = new ElementPlayerEffect(MonsterType.WATER, DAMAGE_FACTOR, DAMAGE_CONSTANT, SECOND_DAMAGE_CONSTANT,
                BONUS_DAMAGE_FACTOR, level);
        effect.applyEffect(aggressor, target);
    }
}
