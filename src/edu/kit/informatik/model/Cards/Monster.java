package edu.kit.informatik.model.Cards;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.abilities.Ability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Monster extends Agent<Monster, Player> {
    private static final int DRAW_INDEX = 0;
    private static final int INITIAL_FOCUS = 0;
    private static final int MIN_FOCUS = 0;
    // TODO: 17.03.22 check everywhere for illegal giving of list without copy
    private final List<MonsterType> monsterTypes;
    private final int level;

    public Monster(String name, int initialHealth, List<MonsterType> monsterTypes,
                   List<Ability<Monster, Player>> abilities, final int level) {
        super(MIN_FOCUS);
        focusPoints = INITIAL_FOCUS;
        this.name = name;
        this.healthPoints = initialHealth;
        this.abilities = new ArrayList<>(abilities);
        this.monsterTypes = new ArrayList<>(monsterTypes);
        this.level = level;
    }

    public Ability<Monster, Player> getNextAbility() {
        // TODO: 26.03.22 skip if not usable
        return abilities.get(DRAW_INDEX); // TODO: 11.03.22 never 0? // TODO: 26.03.22
    }

    public Ability<Monster, Player> activateNextAbility() {
        playedAbility = getNextAbility();
        Collections.rotate(abilities, -1); //leftShift
        return playedAbility;
    }

    public boolean isType(MonsterType type) {
        return this.monsterTypes.contains(type);
    }


    public int getLevel() {
        return level;
    }

    @Override
    public String getFocusPointStatus() {
        return String.format("%d FP", focusPoints);

    }


    public String getHealthStatus() {
        return String.format("%d HP", healthPoints);
    }

    public void damage(final Damage damage) {
        checkDamage(damage);
    }

    public String toString() {
        return this.name;
    }



}
