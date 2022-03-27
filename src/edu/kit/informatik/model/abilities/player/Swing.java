package edu.kit.informatik.model.abilities.player;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.abilities.effects.DamageMonsterWithDice;

/**
 * The type Swing.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Swing extends Ability<Player, Monster> {

    private static final int DAMAGE_FACTOR = 5;

    /**
     * Instantiates a new Swing.
     *
     * @param name  the name
     * @param level the level
     */
    public Swing(final String name, final int level) {
        super(name, level, AbilityType.OFFENSIVE);
        this.setDiceNeed(true);
    }

    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        var effect = new DamageMonsterWithDice(DAMAGE_FACTOR, level, this.getRoll());
        effect.applyEffect(aggressor, target);
    }
}
