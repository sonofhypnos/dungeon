package edu.kit.informatik.model.Cards.abilities;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Cards.Player;
import java.util.List;

/**
 * The enum Player cards.
 *
 * @author upkim
 * @version 1.0.0 10.03.22
 */
public enum PlayerAbilityCards implements Effect {
    /**
     * Slash player cards.
     */
    SLASH(new Slash(0)),
    /**
     * Swing player cards.
     */
    SWING(new Swing(0)),
    /**
     * Thrust player cards.
     */
    THRUST(new Thrust(0)),
    /**
     * Pierce player cards.
     */
    PIERCE(new Pierce(0)),
    /**
     * Parry player cards.
     */
    PARRY(new Parry(0)), FOCUS(new Focus(0)),
    /**
     * Reflect player cards.
     */
    REFLECT(new Reflect(0)),
    /**
     * Water player cards.
     */
    WATER(new WaterPlayer(0)),
    /**
     * Ice player cards.
     */
    ICE(new IcePlayer(0)),
    /**
     * Fire player cards.
     */
    FIRE(new FirePlayer(0)),
    /**
     * Lightning player cards.
     */
    LIGHTNING(new LightningPlayer(0)),
    ;

    private final Ability ability;

    PlayerAbilityCards(final Ability ability) {
        this.ability = ability;
    }


    @Override
    public <A extends Agent, B extends Agent> void applyEffect(final A aggressor, final List<B> targets) {

    }
}


















































