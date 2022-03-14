package edu.kit.informatik.model.Cards.abilities;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Cards.Player;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 11.03.22
 */
public interface Effect {
    public  abstract <A extends Agent, B extends Agent> void applyEffect(A aggressor, List<B> target);
}
