package edu.kit.informatik.model;

/**
 * The enum Archetype. We did not name it class, because of the name clash with the java keyword Class which would have
 * been confusing.
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

    /**
     * Archetype constructor.
     *
     * @param name of the archetype
     */
    Archetype(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
