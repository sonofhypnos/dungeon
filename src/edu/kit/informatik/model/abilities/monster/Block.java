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
public class Block extends MonsterAbility {

    private static final String BLOCK = "Block";

    public Block(final int level) {
        super(level, AbilityType.DEFENSIV);
        this.name = BLOCK;
    }

    @Override
    public void applyEffect(final Monster aggressor, final Player target) {
        aggressor.setProtection(new Damage(DamageType.PHYSICAL, 7 * level));

    }
}
