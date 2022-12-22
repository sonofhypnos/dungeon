package edu.kit.informatik.model.Cards;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.abilities.Ability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Monster implements common functionality of all the monsters.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Monster extends Agent {
    private static final int DRAW_INDEX = 0;
    private static final int INITIAL_FOCUS = 0;
    private static final int MIN_FOCUS = 0;
    private final List<MonsterType> monsterTypes;
    private final int level;
    private final List<Ability<Monster, Player>> abilities;

    /**
     * Instantiates a new Monster.
     *
     * @param name          the name
     * @param initialHealth the initial health
     * @param monsterTypes  the monster types
     * @param abilities     the abilities
     * @param level         the level
     */
    public Monster(String name, int initialHealth, List<MonsterType> monsterTypes,
                   List<Ability<Monster, Player>> abilities, final int level) {
        super(name, MIN_FOCUS, INITIAL_FOCUS, initialHealth, initialHealth);
        this.monsterTypes = new ArrayList<>(monsterTypes);
        this.level = level;
        this.abilities = new ArrayList<>(abilities);
    }

    /**
     * Gets next ability.
     *
     * @return the next ability
     */
    public Ability<Monster, Player> getNextAbility() {
        return abilities.get(DRAW_INDEX);
    }

    /**
     * Activate next ability ability.
     *
     * @return the ability
     */
    public Ability<Monster, Player> activateNextAbility() {
        Ability<Monster, Player> playedAbility = getNextAbility();
        Collections.rotate(abilities, -1); //leftShift
        return playedAbility;
    }

    /**
     * Is type boolean.
     *
     * @param type the type
     * @return the boolean
     */
    public boolean isType(MonsterType type) {
        return this.monsterTypes.contains(type);
    }


    /**
     * Gets level.
     *
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    @Override
    public String getFocusPointStatus() {
        return String.format("%d FP", getFocusPoints());

    }


    @Override
    public String getHealthStatus() {
        return String.format("%d HP", getHealthPoints());
    }

    /**
     * Damage.
     *
     * @param damage the damage
     */
    public void damage(final Damage damage) {
        checkDamage(damage);
    }

    @Override
    public String toString() {
        return getName();
    }


}
