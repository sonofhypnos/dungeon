package edu.kit.informatik.model;

import edu.kit.informatik.model.Cards.DamageType;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Damage {
    private DamageType type;

    public void setAmount(final int amount) {
        this.amount = amount;
    }

    private int amount;

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
