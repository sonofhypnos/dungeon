package edu.kit.informatik.model.abilities.effects;

import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.Cards.DamageType;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.MonsterType;
import edu.kit.informatik.model.Cards.Player;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-17
 */
public class ElementPlayerEffect extends Effect<Player, Monster> {

    private MonsterType monsterType;
    private int damageFactor;
    private int damageConstant;
    private int secondDamageConstant;
    private int bonusDamageFactor;
    private int level;

    public ElementPlayerEffect(MonsterType monsterType, int damageFactor, int damageConstant,
                               int secondDamageConstant,  int bonusDamageFactor,
                               int level){
        this.monsterType = monsterType;
        this.damageFactor = damageFactor;
        this.damageConstant = damageConstant;
        this.secondDamageConstant = secondDamageConstant;
        this.bonusDamageFactor = bonusDamageFactor;
        this.level = level;
    }

    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        int damageAmount = (damageFactor * level + damageConstant) * aggressor.getFocusPoints() + secondDamageConstant;
        if (target.isType(monsterType)) {
            damageAmount += bonusDamageFactor * level;
        }
        var effect = new DamageMonster(new Damage(DamageType.MAGIC, damageAmount));
        effect.applyEffect(aggressor, target);
    }

}
