package edu.kit.informatik.model.abilities;

import edu.kit.informatik.model.Agent;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Focus <A extends Agent<?,?>, T> extends Ability <A,T> {
    private static final String FOCUS_REGEX = "Focus";


    public Focus(final int level) {
        super(FOCUS_REGEX, level, AbilityType.FOCUS);
    }

    public  void applyEffect(final A aggressor, final T target) {
        aggressor.focus(level);
        interFace.focus(aggressor, level);
    }



}
