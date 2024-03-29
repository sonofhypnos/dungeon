package edu.kit.informatik.model.abilities.monster;

import edu.kit.informatik.model.Cards.DamageType;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.abilities.AbilityType;

/**
 * The type Scratch.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Scratch extends MonsterAbility {

    private static final String SCRATCH_REGEX = "Scratch";
    private static final int FACTOR = 5;

    /**
     * Instantiates a new Scratch.
     *
     * @param level the level
     */
    public Scratch(final int level) {
        super(SCRATCH_REGEX, level, AbilityType.OFFENSIVE);
    }

    @Override
    public void applyEffect(final Monster aggressor, final Player target) {
        target.resetFocus();
        target.damage(new Damage(DamageType.PHYSICAL, FACTOR * level), aggressor);
    }

}
