package edu.kit.informatik.model.abilities.effects.rewards;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.effects.Effect;

/**
 * @author upkim
 * @version 1.0.0 2022-03-17
 */
public class newDice extends Effect<Player, Monster> {

    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        aggressor.getNextDice();
        System.out.printf("%s upgrades her die to a %s%n", aggressor, aggressor.getDice());
    }

    @Override
    public String toString() {
        return "next player dice";
    }
}
