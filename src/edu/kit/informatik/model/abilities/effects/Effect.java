package edu.kit.informatik.model.abilities.effects;

import edu.kit.informatik.ui.OutputInterFace;

/**
 * @author upkim
 * @version 1.0.0 11.03.22
 */
public abstract class Effect<A, B> {
    protected OutputInterFace interFace;
    private int roll;

    public Effect() {
        this.interFace = new OutputInterFace();
    }

    public abstract void applyEffect(A aggressor, B target);

    public int getRoll() {
        return roll;
    }

    public void setRoll(final int roll) {
        this.roll = roll;
    }

}

