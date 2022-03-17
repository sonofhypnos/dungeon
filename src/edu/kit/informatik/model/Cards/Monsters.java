package edu.kit.informatik.model.Cards;


import edu.kit.informatik.model.abilities.*;

import edu.kit.informatik.model.abilities.monster.Water;
import java.util.List;

/**
 * The enum Monster cards.
 *
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
// TODO: 12.03.22 potentially add name field for Monsters
public enum Monsters {
//    SPIDER_KING(1, 50, List.of(MonsterType.LIGHTNING, MonsterType.BOSS),
//            List.of(new Bite(1), new Block(1), new Focus("Focus", 1), new Lightning(1))),
//    /**
//     * The Frog.
//     */
//    FROG(1, 16, List.of(MonsterType.WATER), List.of(new Focus("Focus", 1), new Water(1))),
//    /**
//     * The Ghost.
//     */
    GHOST(1, 15, List.of(MonsterType.ICE), List.of(new Focus("Focus", 1), new Water(1))),;
//    /**
//     * The Gorgon.
//     */
//    GORGON(1, 1, List.of(MonsterType.FIRE), List.of(new Focus("Focus", 1), new Fire(1))),
//    /**
//     * The Skeleton.
//     */
//    SKELETON(1, 1, List.of(MonsterType.LIGHTNING), List.of(new Focus("Focus", 1), new Lightning(1))),
//    /**
//     * The Spider.
//     */
//    SPIDER(1, 1, List.of(), List.of(new Bite(1), new Block(1))),
//    /**
//     * The Goblin.
//     */
//    GOBLIN(1, 1, List.of(), List.of(new Smash(1), new Bite(1))),
//    /**
//     * The Rat.
//     */
//    RAT(1, 1, List.of(), List.of(new Block(1), new Claw(1))),
//    /**
//     * The Mushroomlin.
//     */
//    MUSHROOMLIN(1, 1, List.of(), List.of(new Deflect(1), new Scratch(1))),
//    /**
//     * The Snake.
//     */
//    MEGA_SAURUS(1, 100, List.of(MonsterType.BOSS),
//            List.of(new Bite(2), new Block(2), new Focus("Focus", 2), new Fire(1), new Lightning(1))),
//    SNAKE(2, 1, List.of(MonsterType.ICE), List.of(new Bite(2), new Focus("Focus", 2), new Ice(2))),
//    /**
//     * The Dark elf.
//     */
//    DARK_ELF(2, 1, List.of(), List.of(new Focus("Focus", 2), new Water(1), new Lightning(1))),
//    /**
//     * The Shadow blade.
//     */
//    SHADOW_BLADE(2, 1, List.of(MonsterType.LIGHTNING), List.of(new Scratch(2), new Focus("Focus", 2), new Lightning(2))),
//    /**
//     * The Hornet.
//     */
//    HORNET(2, 1, List.of(MonsterType.FIRE), List.of(new Scratch(2), new Focus("Focus", 2), new Fire(1), new Fire(2))),
//    /**
//     * The Tarantula.
//     */
//    TARANTULA(2, 1, List.of(), List.of(new Bite(2), new Block(2), new Scratch(2))),
//    /**
//     * The Bear.
//     */
//    BEAR(2, 1, List.of(), List.of(new Claw(2), new Deflect(2), new Block(2))),
//    /**
//     * The Mushroomlon.
//     */
//    MUSHROOMLON(2, 1, List.of(), List.of(new Deflect(2), new Scratch(2), new Block(2))),
//    /**
//     * The Wild boar.
//     */
//    WILD_BOAR(2, 1, List.of(), List.of(new Scratch(2), new Deflect(2), new Scratch(2)));


    private final Monster monster;

    Monsters(final int level, final int lifePoints, List<MonsterType> monsterTypes,
             List<Ability<Monster, Player>> monsterAbilites) {
        this.monster = new Monster(this.toString(), lifePoints, monsterTypes, monsterAbilites, level);
    }

    /**
     * Gets monster.
     *
     * @return the monster
     */
    public Monster getMonster() {
        return monster;
    }
}
