package edu.kit.informatik.model.Cards;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Monster deck. Deck for drawing monster cards in the Runa game.
 *
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class MonsterDeck extends CardDeck<Monster> {

    /**
     * Instantiates a new Monster deck.
     *
     * @param level the level
     */
    public MonsterDeck(int level) {
        //filter cards by level
        super(Arrays.stream(Monsters.values()).map(Monsters::getMonster)
                .filter((Monster monster) -> monster.getLevel() == level && !monster.isType(MonsterType.BOSS))
                .collect(Collectors.toList()));
    }

}
