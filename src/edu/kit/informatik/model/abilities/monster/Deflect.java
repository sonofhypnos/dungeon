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
public class Deflect extends MonsterAbility {
    public static final String DEFLECT_REGEX = "Deflect";

    public Deflect(final int level) {
        super(DEFLECT_REGEX, level, AbilityType.DEFENSIV);
    }

    @Override
    public void applyEffect(final Monster aggressor, final Player target) {
        aggressor.setProtection(new Damage(DamageType.PHYSICAL, 11 * level + 2));
    }

}
