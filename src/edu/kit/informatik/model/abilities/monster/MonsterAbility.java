package edu.kit.informatik.model.abilities.monster;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public abstract class MonsterAbility extends Ability<Monster, Player> {


    public MonsterAbility(final String name, final int level, final AbilityType type) {
        super(name, level, type);
    }

    public MonsterAbility(final int level, final AbilityType type){
        super("placeholder", level, type);
    }

    @Override
    public abstract void applyEffect(final Monster aggressor, final Player target);

}
