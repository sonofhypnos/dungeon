package edu.kit.informatik.model.abilities.player;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.abilities.effects.DamageMonsterWithDice;

/**
 * The type Slash.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Slash extends Ability<Player, Monster> {

    private static final int DAMAGE_FACTOR = 4;

    /**
     * Instantiates a new Slash.
     *
     * @param slash the slash
     * @param level the level
     */
    public Slash(final String slash, final int level) {
        super(slash, level, AbilityType.OFFENSIVE);
        this.setDiceNeed(true);
    }

    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        var effect = new DamageMonsterWithDice(DAMAGE_FACTOR, level, this.getRoll());
        effect.applyEffect(aggressor, target);
    }
}
