package edu.kit.informatik.model.abilities.player;

import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.Cards.DamageType;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Parry extends Ability<Player, List<Monster>> {

    public Parry(final String name, final int level) {
        super(name, level, AbilityType.DEFENSIV);
    }

    public void applyEffect(final Player aggressor, final List<Monster> target) {
        aggressor.setProtection(new Damage(DamageType.PHYSICAL, 7 * level));
    }


}
