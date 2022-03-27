package edu.kit.informatik.model.Cards;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class MonsterDeck extends CardDeck<Monster> {

    public MonsterDeck(int level) {
        //filter cards by level
        super(Arrays.stream(Monsters.values())
                .map(Monsters::getMonster)
                .filter((Monster monster) -> monster.getLevel() == level && !monster.isType(MonsterType.BOSS))
                .collect(Collectors.toList()));
    }

}
