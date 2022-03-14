package edu.kit.informatik.model.Cards;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Cards.abilities.Ability;

import java.util.Collections;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Monster extends Agent {
    List<MonsterType> monsterTypes;
    int level;
    public Monster(String name, int initialHealth, List<MonsterType> monsterTypes, List<Ability> abilities,
                   final int level){
        focusPoints = 0;
        this.name = name;
        this.healthPoints = initialHealth;
        this.abilities = abilities;
        this.monsterTypes = monsterTypes;
        this.level = level;
    }

    public Ability getNextAbility(){
        return abilities.get(0); // TODO: 11.03.22 never 0?
    }

    public Ability activateNextAbility() {
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
        return String.format("%d", focusPoints);

    }


    public String getHealthStatus(){
        return String.format("%d", healthPoints);
    }

    @Override
    public void damage(final Damage damage) {
        checkDamage(damage);
    }

    // TODO: 14.03.22 tradeoff between UI vs Model and tradeoff abstraction?


}
