package edu.kit.informatik.model.abilities.monster;

import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.Cards.DamageType;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.AbilityType;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Smash extends MonsterAbility {

    private static final int DAMAGE_FACTOR = 8;

    public Smash(final int level) {
        super("Smash", level, AbilityType.OFFENSIV);
    }

    public void applyEffect(final Monster aggressor, final Player target) {
        target.damage(new Damage(DamageType.PHYSICAL, DAMAGE_FACTOR * level), aggressor);
    }


}
