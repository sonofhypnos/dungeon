package edu.kit.informatik.model.Cards.abilities;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Focus extends Ability {


    private static final String FOCUS = "Focus";

    public Focus(final int level) {
        this.level = level;
        this.name = FOCUS;

    }

    public <A extends Player, B extends Player> void applyEffect(final A aggressor, final B target) {


    }

    @Override
    public boolean canBeUsed(final Player p, final Monster m) {
        return true;
    }

    @Override
    public <A extends Agent, B extends Agent> void applyEffect(final A aggressor, final List<B> target) {
        aggressor.setFocusing(true);
    }
}
