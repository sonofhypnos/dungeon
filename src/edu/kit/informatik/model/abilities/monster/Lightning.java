package edu.kit.informatik.model.abilities.monster;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Lightning extends ElementMonsterAbility {


    private static final String LIGHTNING = "Lightning";
    private static final int DAMAGE_CONSTANT = 2;
    private static final int DAMAGE_FACTOR = 14;

    public Lightning(final int level) {
        super(LIGHTNING, level, DAMAGE_FACTOR, DAMAGE_CONSTANT);
    }
}
