package edu.kit.informatik.model.abilities.monster;

import edu.kit.informatik.model.Cards.DamageType;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.abilities.AbilityType;

/**
 * The type Claw.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Claw extends MonsterAbility {

    /**
     * Instantiates a new Claw.
     *
     * @param level the level
     */
    public Claw(final int level) {
        super("Claw", level, AbilityType.OFFENSIVE);
    }

    @Override
    public void applyEffect(final Monster aggressor, final Player target) {
        target.resetFocus();
        target.damage(new Damage(DamageType.PHYSICAL, 6 * level), aggressor);
    }

}
