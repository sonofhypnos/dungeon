package informatik.model.abilities.monster;

/**
 * The type Water.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Water extends ElementMonsterAbility {

    private static final String WATER = "Water";
    private static final int DAMAGE_CONSTANT = 2;
    private static final int DAMAGE_FACTOR = 8;

    /**
     * Instantiates a new Water.
     *
     * @param level the level
     */
    public Water(final int level) {
        super(WATER, level, DAMAGE_FACTOR, DAMAGE_CONSTANT);
    }
}
