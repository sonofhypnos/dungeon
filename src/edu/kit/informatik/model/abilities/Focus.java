package edu.kit.informatik.model.abilities;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.abilities.player.PlayerAbilities;

/**
 * The type Focus.
 *
 * @param <A> the type parameter
 * @param <T> the type parameter
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Focus<A extends Agent, T> extends Ability<A, T> {
    private static final String FOCUS_REGEX = "Focus";


    /**
     * Instantiates a new Focus.
     *
     * @param level the level
     */
    public Focus(final int level) {
        super(FOCUS_REGEX, level, AbilityType.FOCUS);
    }

    /**
     * Instantiates a new Focus.
     *
     * @param initialLevel    the initial level
     * @param playerAbilities the player abilities
     */
    public Focus(final int initialLevel, final PlayerAbilities playerAbilities) {
        super(FOCUS_REGEX, initialLevel, AbilityType.FOCUS, playerAbilities);
    }

    @Override
    public void applyEffect(final A aggressor, final T target) {
        aggressor.focus(level);
    }


}
