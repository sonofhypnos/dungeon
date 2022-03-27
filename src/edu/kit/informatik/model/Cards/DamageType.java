package edu.kit.informatik.model.Cards;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public enum DamageType {
    MAGIC("mag."), PHYSICAL("phy."),;

    private final String name;

    DamageType(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
