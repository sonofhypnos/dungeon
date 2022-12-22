package informatik.model.Cards;


import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.Focus;
import edu.kit.informatik.model.abilities.monster.*;

import java.util.List;

/**
 * Monster Enums. Initializes the Monsters with their abilities.
 */
public enum Monsters {
    /* Arguments for every Monster constructor here:
    Name, level, lifePoints , Types of the Monster, Abilities of the Monster*/
    /**
     * The Spider king.
     */
    SPIDER_KING("Spider King", 1, 50, List.of(MonsterType.LIGHTNING, MonsterType.BOSS),
            List.of(new Bite(1), new Block(1), new Focus<>(1), new Lightning(1))),
    /**
     * The Frog.
     */
    FROG("Frog", 1, 16, List.of(MonsterType.WATER), List.of(new Focus<>(1), new Water(1))),
    /**
     * The Ghost.
     */
    GHOST("Ghost", 1, 15, List.of(MonsterType.ICE), List.of(new Focus<>(1), new Ice(1))),
    /**
     * The Gorgon.
     */
    GORGON("Gorgon", 1, 13, List.of(MonsterType.FIRE), List.of(new Focus<>(1), new Fire(1))),
    /**
     * The Skeleton.
     */
    SKELETON("Skeleton", 1, 14, List.of(MonsterType.LIGHTNING), List.of(new Focus<>(1), new Lightning(1))),
    /**
     * The Spider.
     */
    SPIDER("Spider", 1, 15, List.of(), List.of(new Bite(1), new Block(1))),
    /**
     * The Goblin.
     */
    GOBLIN("Goblin", 1, 12, List.of(), List.of(new Smash(1), new Deflect(1))),
    /**
     * The Rat.
     */
    RAT("Rat", 1, 14, List.of(), List.of(new Block(1), new Claw(1))),
    /**
     * The Mushroomlin.
     */
    MUSHROOMLIN("Mushroomlin", 1, 20, List.of(), List.of(new Deflect(1), new Scratch(1))),
    /**
     * The Mega saurus.
     */
    MEGA_SAURUS("Mega Saurus", 2, 100, List.of(MonsterType.BOSS),
            List.of(new Bite(2), new Block(2), new Focus<>(2), new Fire(1), new Lightning(1))),
    /**
     * The Snake.
     */
    SNAKE("Snake", 2, 31, List.of(MonsterType.ICE), List.of(new Bite(2), new Focus<>(2), new Ice(2))),
    /**
     * The Dark elf.
     */
    DARK_ELF("Dark Elf", 2, 34, List.of(), List.of(new Focus<>(2), new Water(1), new Lightning(1))),
    /**
     * The Shadow blade.
     */
    SHADOW_BLADE("Shadow Blade", 2, 27, List.of(MonsterType.LIGHTNING),
            List.of(new Scratch(2), new Focus<>(2), new Lightning(2))),
    /**
     * The Hornet.
     */
    HORNET("Hornet", 2, 32, List.of(MonsterType.FIRE),
            List.of(new Scratch(2), new Focus<>(2), new Fire(1), new Fire(2))),
    /**
     * The Tarantula.
     */
    TARANTULA("Tarantula", 2, 33, List.of(), List.of(new Bite(2), new Block(2), new Scratch(2))),
    /**
     * The Bear.
     */
    BEAR("Bear", 2, 40, List.of(), List.of(new Claw(2), new Deflect(2), new Block(2))),
    /**
     * The Mushroomlon.
     */
    MUSHROOMLON("Mushroomlon", 2, 50, List.of(), List.of(new Deflect(2), new Scratch(2), new Block(2))),
    /**
     * The Wild boar.
     */
    WILD_BOAR("Wild Boar", 2, 27, List.of(), List.of(new Scratch(2), new Deflect(2), new Scratch(2)));


    private final Monster monster;

    /**
     * Instantiates a new Monster.
     *
     * @param name name of the Monster
     * @param level the Monster appears in.
     * @param lifePoints the Monster starts with.
     * @param monsterTypes the Monster has.
     * @param monsterAbilities the Monster has.
     */
    Monsters(final String name, final int level, final int lifePoints, List<MonsterType> monsterTypes,
             List<Ability<Monster, Player>> monsterAbilities) {
        this.monster = new Monster(name, lifePoints, monsterTypes, monsterAbilities, level);
    }

    /**
     * Gets monster.
     *
     * @return the Monster
     */
    public Monster getMonster() {
        return monster;
    }
}
