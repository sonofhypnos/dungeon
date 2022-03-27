package edu.kit.informatik.model.abilities;

import edu.kit.informatik.model.Agent;

/**
 * The type Focus.
 *
 * @param <A> the type parameter
 * @param <T> the type parameter
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Focus<A extends Agent<?, ?>, T> extends Ability<A, T> {
    private static final String FOCUS_REGEX = "Focus";


    /**
     * Instantiates a new Focus.
     *
     * @param level the level
     */
    public Focus(final int level) {
        super(FOCUS_REGEX, level, AbilityType.FOCUS);
    }

    @Override
    public void applyEffect(final A aggressor, final T target) {
        aggressor.focus(level);
    }


}
