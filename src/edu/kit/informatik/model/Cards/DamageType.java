package edu.kit.informatik.model.Cards;

/**
 * The enum Damage type.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public enum DamageType {
    /**
     * Magic damage type.
     */
    MAGIC("mag."),
    /**
     * Physical damage type.
     */
    PHYSICAL("phy."),;

    private final String name;

    /**
     * Constructor creates new DamageType. We added this constructor, since the Checkstyle complained, if we added
     * the private keyword, that this would be redundant for enums, but also complained about the lacking Java-dock
     * when we removed the keyword.
     * @param name name of the Damage type
     */
    DamageType(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
