package edu.kit.informatik.model.abilities.effects;

import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Runa;

/**
 * @author upkim
 * @version 1.0.0 2022-03-17
 */
public class DamageMonster extends Effect<Player, Monster> {

    private Damage damage;

    public DamageMonster(Damage damage) {
        // TODO: 26.03.22 see below:

//        2) Parry(1)
//        Enter number [1--2]:
//        1
//        Runa uses Thrust(1)
//        Select Runa's target.
//        1) Spider
//        2) Rat
//        Enter number [1--2]:
//        1
//        Enter dice roll [1--6]:
//        6
//        Spider takes 5 phy. damage (Actual damage here should be 9!)
//        Spider uses Bite(1)
//        Runa takes 10 phy. damage
//        Rat uses Block(1
        this.damage = damage;
    }
    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        target.damage(damage);
        if (target.isDead()) {
            interFace.dies(target);
        }
    }
}
