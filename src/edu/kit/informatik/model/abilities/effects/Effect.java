package edu.kit.informatik.model.abilities.effects;

import edu.kit.informatik.ui.OutputInterFace;

/**
 * The type Effect.
 *
 * @param <A> the type parameter
 * @param <B> the type parameter
 * @author upkim
 * @version 1.0.0 11.03.22
 */
public abstract class Effect<A, B> {
    /**
     * The Inter face.
     */
    protected OutputInterFace interFace;
    private int roll;

    /**
     * Instantiates a new Effect.
     */
    public Effect() {
        this.interFace = new OutputInterFace();
    }

    /**
     * Apply effect.
     *
     * @param aggressor the aggressor
     * @param target    the target
     */
    public abstract void applyEffect(A aggressor, B target);

    /**
     * Gets roll.
     *
     * @return the roll
     */
    public int getRoll() {
        return roll;
    }

    /**
     * Sets roll.
     *
     * @param roll the roll
     */
    public void setRoll(final int roll) {
        this.roll = roll;
    }

}

