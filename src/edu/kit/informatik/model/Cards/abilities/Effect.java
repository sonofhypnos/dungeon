package edu.kit.informatik.model.Cards.abilities;

import edu.kit.informatik.model.Cards.Player;

/**
 * @author upkim
 * @version 1.0.0 11.03.22
 */
public interface Effect {
    public  abstract <A extends Player, B extends Player> void applyEffect(A aggressor, B target);
}
