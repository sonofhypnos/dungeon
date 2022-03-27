package edu.kit.informatik.model.abilities.effects;

import edu.kit.informatik.model.Cards.DamageType;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.MonsterType;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Damage;

/**
 * The type Element player effect.
 *
 * @author upkim
 * @version 1.0.0 2022-03-17
 */
public class ElementPlayerEffect extends Effect<Player, Monster> {

    private static final int FOCUS_POINT_COST = 1;
    private final MonsterType monsterType;
    private final int damageFactor;
    private final int damageConstant;
    private final int secondDamageConstant;
    private final int bonusDamageFactor;
    private final int level;

    /**
     * Instantiates a new Element player effect.
     *
     * @param monsterType          the monster type
     * @param damageFactor         the damage factor
     * @param damageConstant       the damage constant
     * @param secondDamageConstant the second damage constant
     * @param bonusDamageFactor    the bonus damage factor
     * @param level                the level
     */
    public ElementPlayerEffect(MonsterType monsterType, int damageFactor, int damageConstant, int secondDamageConstant,
                               int bonusDamageFactor, int level) {
        this.monsterType = monsterType;
        this.damageFactor = damageFactor;
        this.damageConstant = damageConstant;
        this.secondDamageConstant = secondDamageConstant;
        this.bonusDamageFactor = bonusDamageFactor;
        this.level = level;
    }

    @Override
    public void applyEffect(final Player player, final Monster target) {
        int damageAmount = (damageFactor * level + damageConstant) * player.getFocusPoints() + secondDamageConstant;
        if (target.isType(monsterType)) {
            damageAmount += bonusDamageFactor * level;
        }
        var effect = new DamageMonster(new Damage(DamageType.MAGIC, damageAmount));
        player.reduceFocus(FOCUS_POINT_COST);
        effect.applyEffect(player, target);
    }

}
