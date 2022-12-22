package informatik.model.abilities.effects;

/**
 * The effect class implements is for the effects of different abilities as well as for rewards that get chosen by the
 * user through the Prompt-output.
 *
 * @param <A> the type parameter
 * @param <B> the type parameter
 * @author upkim
 * @version 1.0.0 11.03.22
 */
public abstract class Effect<A, B> {
    private int roll;

    /**
     * Instantiates a new Effect.
     */
    public Effect() {
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

