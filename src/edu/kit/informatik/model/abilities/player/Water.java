package edu.kit.informatik.model.abilities.player;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.MonsterType;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.abilities.effects.ElementPlayerEffect;

/**
 * WaterAbility by the player.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Water extends Ability<Player, Monster> {
    /**
     * Instantiates new WaterAbility
     *
     * @param name  the name
     * @param level the level
     */
    public Water(final String name, final int level) {
        super(name, level, AbilityType.OFFENSIVE);
    }

    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        var effect = new ElementPlayerEffect(MonsterType.LIGHTNING, 2, 4, 0, 2, level);
        effect.applyEffect(aggressor, target);
    }

}