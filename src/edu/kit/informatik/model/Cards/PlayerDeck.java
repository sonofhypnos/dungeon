package edu.kit.informatik.model.Cards;

import edu.kit.informatik.model.Cards.abilities.PlayerAbilityCards;

import java.util.ArrayList;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class PlayerDeck extends CardDeck<PlayerAbilityCards>{


    /**
     * Instantiates a new Card deck.
     */
    public PlayerDeck() {
        super(new ArrayList<>(List.of(PlayerAbilityCards.values())));
    }
}
