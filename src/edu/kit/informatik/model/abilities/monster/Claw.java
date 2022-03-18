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
public class Claw extends MonsterAbility {

    public Claw(final int level) {
        super(level, AbilityType.OFFENSIV);
    }

    public void applyEffect(final Monster aggressor, final Player target) {
        target.resetFocus();
        // TODO: 17.03.22 check for message when breaking focus?
        target.damage(new Damage(DamageType.PHYSICAL, 6 * level), aggressor);
    }




    @Override
    public String toString() {
        return String.format("Claw", level);
    }
}
