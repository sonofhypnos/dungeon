package informatik.model.abilities.monster;

import edu.kit.informatik.model.Cards.DamageType;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.abilities.AbilityType;

/**
 * The type Block.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Block extends MonsterAbility {

    private static final String BLOCK = "Block";
    private static final int FACTOR = 7;

    /**
     * Instantiates a new Block.
     *
     * @param level the level
     */
    public Block(final int level) {
        super(BLOCK, level, AbilityType.DEFENSIVE);
    }

    @Override
    public void applyEffect(final Monster aggressor, final Player target) {
        aggressor.setProtection(new Damage(DamageType.PHYSICAL, FACTOR * level));
    }
}
