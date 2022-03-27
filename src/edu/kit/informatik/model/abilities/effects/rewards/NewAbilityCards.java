package edu.kit.informatik.model.abilities.effects.rewards;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Cards.PlayerDeck;
import edu.kit.informatik.model.abilities.effects.Effect;
import edu.kit.informatik.ui.prompts.SelectPrompt;

/**
 * The type New ability cards.
 *
 * @author upkim
 * @version 1.0.0 2022-03-17
 */
public class NewAbilityCards extends Effect<Player, Monster> {
    private static final String PICK_S_CARD_S_AS_LOOT = "Pick %s card(s) as loot";
    private final PlayerDeck cards;
    private final int cardNumber;
    private final int cardPoolSize;

    /**
     * Instantiates new Ability Card Effect.
     *
     * @param cards        the cards
     * @param cardNumber   the card number
     * @param cardPoolSize the card pool size
     */
    public NewAbilityCards(PlayerDeck cards, int cardNumber, int cardPoolSize) {
        this.cards = cards;
        this.cardNumber = cardNumber;
        this.cardPoolSize = cardPoolSize;
    }


    @Override
    public void applyEffect(final Player player, final Monster target) {
        // TODO: 26.03.22 The number of cards is more than what is the stuff!
        var newCards = this.cards.draw(cardPoolSize);
        int optionNumber = Math.min(newCards.size()-1, cardNumber);
        if (optionNumber != 0) {
            var abilityPrompt = new SelectPrompt<>(
                    String.format(String.format(PICK_S_CARD_S_AS_LOOT, cardNumber), newCards.size()), newCards,
                    optionNumber, optionNumber);

            var loot = abilityPrompt.parseList();
            if (!SelectPrompt.isRunning()) {
                return;
            }
            for (var card : loot) {
                player.addCard(card);
                interFace.getCard(player, card);
            }
        }
    }

    @Override
    public String toString() {
        return "new ability cards";
    }
}
