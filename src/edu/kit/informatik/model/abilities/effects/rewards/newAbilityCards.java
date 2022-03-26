package edu.kit.informatik.model.abilities.effects.rewards;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Cards.PlayerDeck;
import edu.kit.informatik.model.Runa;
import edu.kit.informatik.model.abilities.effects.Effect;
import edu.kit.informatik.ui.prompts.SelectPrompt;

/**
 * @author upkim
 * @version 1.0.0 2022-03-17
 */
public class newAbilityCards extends Effect<Player, Monster> {
    private final PlayerDeck cards;
    private final int cardNumber;
    private int cardPoolSize;
    private final Runa runa;

    public newAbilityCards(PlayerDeck cards, int cardNumber, int cardPoolSize ,Runa runa){
        this.cards = cards;
        this.cardNumber = cardNumber;
        this.cardPoolSize = cardPoolSize;
        this.runa = runa;
    }


    @Override
    public void applyEffect(final Player player, final Monster target) {
        // TODO: 26.03.22 The number of cards is more than what is the stuff!
        var newCards = this.cards.draw(cardPoolSize);
        var abilityPrompt = new SelectPrompt<>(String.format(String.format("Pick %s card(s) as loot", cardNumber),
                newCards.size()), newCards, cardNumber, cardNumber);

        var loot = abilityPrompt.parseList();
        if (runa.checkQuit(loot)) {
            return;
        }
        for (var card : loot) {
            player.addCard(card);
            interFace.getCard(player, card);
        }
    }

    @Override
    public String toString() {
        return "new ability cards";
    }
}
