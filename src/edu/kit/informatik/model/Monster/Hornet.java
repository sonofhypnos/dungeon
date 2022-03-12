package edu.kit.informatik.model.Monster;

import edu.kit.informatik.model.Cards.MonsterType;
import edu.kit.informatik.model.Cards.abilities.Ability;
import edu.kit.informatik.model.Cards.Monster;

import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Hornet extends Monster {

    public Hornet(final String name, final List<MonsterType> monsterTypes, final int initialHealth, final List<Ability> abilities) {
        super(name, monsterTypes, initialHealth, abilities);
    }
}
