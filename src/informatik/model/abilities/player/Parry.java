package informatik.model.abilities.player;

import edu.kit.informatik.model.Cards.DamageType;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;

/**
 * The type Parry.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Parry extends Ability<Player, Monster> {

    private static final int DEFENSE_FACTOR = 7;

    /**
     * Instantiates a new Parry.
     *
     * @param name            the name
     * @param level           the level
     * @param playerAbilities the player abilities
     */
    public Parry(final String name, final int level, final PlayerAbilities playerAbilities) {
        super(name, level, AbilityType.DEFENSIVE, playerAbilities);
    }


    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        aggressor.setProtection(new Damage(DamageType.PHYSICAL, DEFENSE_FACTOR * level));
    }


}
