package edu.kit.informatik.model.Cards;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Cards.abilities.Effect;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-14
 */
public class DoDamage implements Effect {


    @Override
    public <A extends Agent, B extends Agent> void applyEffect(final A aggressor, final List<B> target) {


    }
}
