package edu.kit.informatik.model.abilities;

import edu.kit.informatik.model.Agent;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Focus <A extends Agent<?,?>, T> extends Ability <A,T> {
    private static final String FOCUS = "Focus";

    public Focus(final String name, final int level) {
        super(name, level, AbilityType.FOCUS);
    }

    public Focus(final int level) {
        super(FOCUS, level, AbilityType.FOCUS);
    }

    public  void applyEffect(final A aggressor, final T target) {
        aggressor.focus(level);
    }



}
