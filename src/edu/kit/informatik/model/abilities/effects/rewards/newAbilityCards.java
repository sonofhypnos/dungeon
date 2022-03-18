package edu.kit.informatik.model.abilities.effects.rewards;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Cards.PlayerDeck;
import edu.kit.informatik.model.abilities.effects.Effect;
import edu.kit.informatik.ui.prompts.SelectPrompt;

/**
 * @author upkim
 * @version 1.0.0 2022-03-17
 */
public class newAbilityCards extends Effect<Player, Monster> {
    private final PlayerDeck cards;
    private final int cardNumber;

    public newAbilityCards(PlayerDeck cards, int cardNumber){
        this.cards = cards;
        this.cardNumber = cardNumber;
    }


    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        var newCards = this.cards.draw(cardNumber);
        var abilityPrompt = new SelectPrompt<>("%s", newCards);
        abilityPrompt.parseList();

    }

    @Override
    public String toString() {
        return "new ability cards";
    }
}
