package edu.kit.informatik.model.Cards;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Damage {
    DamageType type;
    int amount;

    public Damage(final DamageType type, final int amount) {
        this.type = type;
        this.amount = amount;
    }

    public DamageType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }
}
