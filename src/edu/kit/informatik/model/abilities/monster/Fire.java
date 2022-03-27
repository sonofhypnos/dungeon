package edu.kit.informatik.model.abilities.monster;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Fire extends ElementMonsterAbility {

    private static final String FIRE = "Fire";
    private static final int DAMAGE_CONSTANT = 2;
    private static final int DAMAGE_FACTOR = 12;

    public Fire(final int level) {
        super(FIRE,level, DAMAGE_FACTOR, DAMAGE_CONSTANT);
    }


}
