package edu.kit.informatik.model;

/**
 * The enum Class.
 *
 * @author upkim
 * @version 1.0.0 10.03.22
 */
public enum Archetype {
    /**
     * Warrior class.
     */
    WARRIOR("Warrior"),
    /**
     * Mage class.
     */
    MAGE("Mage"),
    /**
     * Paladin class.
     */
    PALADIN("Paladin");

    private final String name;

    private Archetype(final String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

}
