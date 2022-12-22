package informatik.model.abilities.monster;

/**
 * The type Fire.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Fire extends ElementMonsterAbility {

    private static final String FIRE = "Fire";
    private static final int DAMAGE_CONSTANT = 2;
    private static final int DAMAGE_FACTOR = 12;

    /**
     * Instantiates a new Fire.
     *
     * @param level the level
     */
    public Fire(final int level) {
        super(FIRE, level, DAMAGE_FACTOR, DAMAGE_CONSTANT);
    }


}
