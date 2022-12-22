package informatik.model.abilities.monster;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;

/**
 * The type Monster ability.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public abstract class MonsterAbility extends Ability<Monster, Player> {


    /**
     * Instantiates a new Monster ability.
     *
     * @param name  the name
     * @param level the level
     * @param type  the type
     */
    public MonsterAbility(final String name, final int level, final AbilityType type) {
        super(name, level, type);
    }


    @Override
    public abstract void applyEffect(Monster aggressor, Player target);

}
