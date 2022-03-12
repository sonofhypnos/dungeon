package edu.kit.informatik.model.Cards.abilities;

import edu.kit.informatik.model.Cards.Player;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Claw extends MonsterAbility{

    public Claw(final int level) {
        super(level);
    }

    @Override
    public <A extends Player, B extends Player> void applyEffect(final A aggressor, final B target) {


    }




    @Override
    public String toString() {
        return String.format("Claw", level);
    }

}
