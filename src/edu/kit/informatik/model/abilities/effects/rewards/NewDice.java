package edu.kit.informatik.model.abilities.effects.rewards;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.effects.Effect;

/**
 * The type New dice.
 *
 * @author upkim
 * @version 1.0.0 2022-03-17
 */
public class NewDice extends Effect<Player, Monster> {

    private static final String NEW_DICE = "next player dice";

    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        aggressor.getNextDice();
        interFace.upgrade(aggressor, aggressor.getDice());
    }

    @Override
    public String toString() {
        return NEW_DICE;
    }
}
