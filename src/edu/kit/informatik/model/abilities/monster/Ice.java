package edu.kit.informatik.model.abilities.monster;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Ice extends ElementMonsterAbility {
    private static final String ICE = "Ice";
    private static final int DAMAGE_CONSTANT = 2;
    private static final int DAMAGE_FACTOR = 10;

    public Ice(final int level) {
        super(ICE, level, DAMAGE_FACTOR, DAMAGE_CONSTANT);
    }


}