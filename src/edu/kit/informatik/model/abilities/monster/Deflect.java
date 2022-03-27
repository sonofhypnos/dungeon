package edu.kit.informatik.model.abilities.monster;

import edu.kit.informatik.model.Cards.DamageType;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.abilities.AbilityType;

/**
 * The type Deflect.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Deflect extends MonsterAbility {
    /**
     * The constant DEFLECT_REGEX.
     */
    public static final String DEFLECT_REGEX = "Deflect";

    /**
     * Instantiates a new Deflect.
     *
     * @param level the level
     */
    public Deflect(final int level) {
        super(DEFLECT_REGEX, level, AbilityType.DEFENSIVE);
    }

    @Override
    public void applyEffect(final Monster aggressor, final Player target) {
        aggressor.setProtection(new Damage(DamageType.MAGIC, 11 * level + 2));
    }

}
