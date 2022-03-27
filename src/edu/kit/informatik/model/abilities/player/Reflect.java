package edu.kit.informatik.model.abilities.player;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;

/**
 * The type Reflect.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Reflect extends Ability<Player, Monster> {

    /**
     * Instantiates a new Reflect.
     *
     * @param name  the name
     * @param level the level
     */
    public Reflect(final String name, final int level) {
        super(name, level, AbilityType.DEFENSIVE);
    }


    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        aggressor.setReflect(true);
    }
}
