package edu.kit.informatik.model.abilities.player;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityKind;
import edu.kit.informatik.model.abilities.Focus;
import java.util.List;

/**
 * The enum Player cards.
 *
 * @author upkim
 * @version 1.0.0 10.03.22
 */
public enum PlayerAbilities implements AbilityKind {
//    /**
//     * Slash player cards.
//     */
//    SLASH(new Slash("Slash", 0)),
//    /**
//     * Swing player cards.
//     */
//    SWING(new Swing("Swing", 0)),
//    /**
//     * Thrust player cards.
//     */
    THRUST(new Thrust("Thrust", 0)),
//    /**
//     * Pierce player cards.
//     */
//    PIERCE(new Pierce("Pierce", 0)),
//    /**
//     * Parry player cards.
//     */
    PARRY(new Parry("Parry", 0)),
    FOCUS(new Focus<>("Focus", 0)),
//    /**
//     * Reflect player cards.
//     */
//    REFLECT(new Reflect("Reflect", 0)),
//    /**
//     * Water player cards.
//     */
//    WATER(new WaterPlayer("WaterPlayer", 0)),
//    /**
//     * Ice player cards.
//     */
//    ICE(new IcePlayer("IcePlayer", 0)),
//    /**
//     * Fire player cards.
//     */
//    FIRE(new FirePlayer("FirePlayer", 0)),
//    /**
//     * Lightning player cards.
//     */
//    LIGHTNING(new LightningPlayer("LightningPlayer", 0)),
    ;

    private final Ability<Player, List<Monster>> ability;

    PlayerAbilities(final Ability<Player, List<Monster>> ability) {
        ability.setIdentifier(this);
        this.ability = ability;
    }

    public Ability<Player, List<Monster>> getAbility() {
        return ability;
    }

    public void applyEffect(final Player aggressor, final List<Monster> targets) {

    }

}


















































