package edu.kit.informatik.model.abilities.monster;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Cards.DamageType;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.abilities.AbilityType;

/**
 * The type Element monster ability.
 *
 * @author upkim
 * @version 1.0.0 2022-03-17
 */
public class ElementMonsterAbility extends MonsterAbility {
    private final int damageFactor;
    private final int damageConstant;


    /**
     * Instantiates a new Element monster ability.
     *
     * @param name           the name
     * @param level          the level
     * @param damageFactor   the damage factor
     * @param damageConstant the damage constant
     */
    public ElementMonsterAbility(final String name, final int level, final int damageFactor, final int damageConstant) {
        super(name, level, AbilityType.OFFENSIVE);
        this.damageFactor = damageFactor;
        this.damageConstant = damageConstant;
    }

    @Override
    public boolean canBeUsed(final Agent<?, ?> agent) {
        return agent.getFocusPoints() <= this.level;
    }


    @Override
    public void applyEffect(final Monster aggressor, final Player target) {
        assert canBeUsed(aggressor);
        aggressor.reduceFocus(this.level);
        target.damage(new Damage(DamageType.MAGIC, damageFactor * level + damageConstant), aggressor);
    }
}
