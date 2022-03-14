package edu.kit.informatik.model.Cards.abilities;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class MonsterAbility extends Ability{


    public MonsterAbility(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", name, level);
    }

    @Override
    public boolean canBeUsed(final Player p, final Monster m) {
        return false;
    }

    @Override
    public <A extends Agent, B extends Agent> void applyEffect(final A aggressor, final List<B> target) {

    }
}
