package informatik.model;

import edu.kit.informatik.model.abilities.player.PlayerAbilities;

import java.util.List;

/**
 * The enum Archetype. We did not name it class, because of the name clash with the java keyword for class which would
 * have been confusing.
 *
 * @author upkim
 * @version 1.0.0 10.03.22
 */
public enum Archetype {
    /**
     * Warrior class.
     */
    WARRIOR("Warrior", List.of(PlayerAbilities.THRUST, PlayerAbilities.PARRY)),
    /**
     * Mage class.
     */
    MAGE("Mage", List.of(PlayerAbilities.FOCUS, PlayerAbilities.WATER)),

    /**
     * Paladin class.
     */
    PALADIN("Paladin", List.of(PlayerAbilities.SLASH, PlayerAbilities.REFLECT));

    private final String name;
    private final List<PlayerAbilities> abilities;


    /**
     * Instantiates archetype
     * @param name name of the Archetype
     * @param startingCards Starting Cards of archetype
     */
    Archetype(final String name, final List<PlayerAbilities> startingCards) {
        this.name = name;
        abilities = startingCards;
    }

    @Override
    public String toString() {
        return this.name;
    }


    /**
     * Gets abilities.
     *
     * @return the abilities
     */
    public List<PlayerAbilities> getAbilities() {
        return abilities;
    }
}
