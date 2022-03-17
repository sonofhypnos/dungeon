package edu.kit.informatik.model.abilities.monster;

import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.Cards.DamageType;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Bite extends MonsterAbility {

    private static final int DAMAGE_FACTOR = 10;

    public Bite(final int level) {
        super(level);
    }

    public void applyEffect(final Monster aggressor, final Player target) {
        target.damage(new Damage(DamageType.PHYSICAL, DAMAGE_FACTOR * level), aggressor);
    }

    @Override
    public String toString() {
        return String.format("Bite(%d)", level);
    }

}

