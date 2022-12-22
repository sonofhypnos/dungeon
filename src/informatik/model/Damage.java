package informatik.model;

import edu.kit.informatik.model.Cards.DamageType;

/**
 * Damage class stores magnitude as well as type of damage.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Damage {
    private final DamageType type;
    private int amount;

    /**
     * Instantiates new Damage.
     */
    public Damage() {
        this.amount = 0;
        this.type = DamageType.PHYSICAL;
    }

    /**
     * Instantiates new Damage.
     *
     * @param type   the type
     * @param amount the amount
     */
    public Damage(final DamageType type, final int amount) {
        this.type = type;
        this.amount = amount;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public DamageType getType() {
        return type;
    }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the amount
     */
    public void setAmount(final int amount) {
        this.amount = Math.max(amount, 0);
    }
}
