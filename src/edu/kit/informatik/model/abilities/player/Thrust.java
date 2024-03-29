package edu.kit.informatik.model.abilities.player;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.abilities.effects.DamageWithThreshhold;

/**
 * The type Thrust.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Thrust extends Ability<Player, Monster> {

    private static final int BONUS_FACTOR = 4;
    private static final int BONUS_THRESHHOLD = 6;
    private static final int DAMAGE_FACTOR = 6;

    /**
     * Instantiates a new Thrust.
     *
     * @param thrust          the thrust
     * @param level           the level
     * @param playerAbilities the player abilities
     */
    public Thrust(final String thrust, final int level, final PlayerAbilities playerAbilities) {
        super(thrust, level, AbilityType.OFFENSIVE, playerAbilities);
        this.type = AbilityType.OFFENSIVE;
        this.setDiceNeed(true);
    }

    @Override
    public void applyEffect(final Player aggressor, final Monster target) {
        var effect = new DamageWithThreshhold(BONUS_THRESHHOLD, DAMAGE_FACTOR, BONUS_FACTOR, this.level,
                this.getRoll());
        effect.applyEffect(aggressor, target);
    }
}
