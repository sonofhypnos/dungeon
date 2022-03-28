package edu.kit.informatik.model.abilities.effects;

import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.ui.Messaging;

/**
 * The type Damage monster.
 *
 * @author upkim
 * @version 1.0.0 2022-03-17
 */
public class DamageMonster extends Effect<Player, Monster> {

    private final Damage damage;

    /**
     * Instantiates a new Damage monster.
     *
     * @param damage the damage
     */
    public DamageMonster(Damage damage) {
        this.damage = damage;
    }

    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        target.damage(damage);
        if (target.isDead()) {
            Messaging.dies(target);
        }
    }
}
