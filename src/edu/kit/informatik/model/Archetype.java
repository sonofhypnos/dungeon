package edu.kit.informatik.model;

import edu.kit.informatik.model.abilities.player.PlayerAbilities;
import java.util.ArrayList;
import java.util.List;

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
    private List<PlayerAbilities> abilities;


    Archetype(final String name, final List<PlayerAbilities> playerAbilities) {
        this.name = name;
        abilities = playerAbilities;
    }

    @Override
    public String toString() {
        return this.name;
    }


    public List<PlayerAbilities> getAbilities() {
        return abilities;
    }
}
