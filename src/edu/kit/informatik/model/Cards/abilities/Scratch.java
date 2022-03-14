package edu.kit.informatik.model.Cards.abilities;

import edu.kit.informatik.model.Cards.Player;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Scratch extends MonsterAbility {

    public Scratch(final int level) {
        super(level);
    }

    public <A extends Player, B extends Player> void applyEffect(final A aggressor, final B target) {

    }


    @Override
    public String toString() {
        return String.format("Scratch", level);
    }

}
