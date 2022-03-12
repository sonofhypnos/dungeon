package edu.kit.informatik.model.Cards.abilities;

import edu.kit.informatik.model.Cards.Player;

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
SLASH(new Slash()),
    /**
     * Swing player cards.
     */
SWING(new Swing()),
    /**
     * Thrust player cards.
     */
THRUST(new Thrust()),
    /**
     * Pierce player cards.
     */
PIERCE(new Pierce()),
    /**
     * Parry player cards.
     */
PARRY(new Parry()),
    /**
     * Focus player cards.
     */
FOCUS(new FocusPlayer()),
    /**
     * Reflect player cards.
     */
REFLECT(new Reflect()),
    /**
     * Water player cards.
     */
WATER(new WaterPlayer()),
    /**
     * Ice player cards.
     */
ICE(new IcePlayer()),
    /**
     * Fire player cards.
     */
FIRE(new FirePlayer()),
    /**
     * Lightning player cards.
     */
LIGHTNING(new LightningPlayer()),
    ;

    private final Ability ability;

    PlayerAbilityCards(final Ability ability) {
        this.ability = ability;
    }

    @Override
    public <A extends Player, B extends Player> void applyEffect(final A aggressor, final B target) {
        this.ability.applyEffect(aggressor, target);
    }
}


















































