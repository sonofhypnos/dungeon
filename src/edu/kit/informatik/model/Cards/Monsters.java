package edu.kit.informatik.model.Cards;


import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.Focus;
import edu.kit.informatik.model.abilities.monster.Bite;
import edu.kit.informatik.model.abilities.monster.Block;
import edu.kit.informatik.model.abilities.monster.Claw;
import edu.kit.informatik.model.abilities.monster.Deflect;
import edu.kit.informatik.model.abilities.monster.Fire;
import edu.kit.informatik.model.abilities.monster.Ice;
import edu.kit.informatik.model.abilities.monster.Lightning;
import edu.kit.informatik.model.abilities.monster.Scratch;
import edu.kit.informatik.model.abilities.monster.Smash;
import edu.kit.informatik.model.abilities.monster.Water;
import java.util.List;

// TODO: 12.03.22 potentially add name field for Monsters
public enum Monsters {
    SPIDER_KING("Spider King", 1, 50, List.of(MonsterType.LIGHTNING, MonsterType.BOSS),
            List.of(new Bite(1), new Block(1), new Focus<>(1), new Lightning(1))),
    FROG("Frog", 1, 16, List.of(MonsterType.WATER), List.of(new Focus<>(1), new Water(1))),
    GHOST("Ghost", 1, 15, List.of(MonsterType.ICE), List.of(new Focus<>(1), new Ice(1))),
    GORGON("Gorgon", 1, 13, List.of(MonsterType.FIRE), List.of(new Focus<>(1), new Fire(1))),
    SKELETON("Skeleton", 1, 14, List.of(MonsterType.LIGHTNING), List.of(new Focus<>(1), new Lightning(1))),
    SPIDER("Spider", 1, 15, List.of(), List.of(new Bite(1), new Block(1))),
    GOBLIN("Goblin", 1, 12, List.of(), List.of(new Smash(1), new Bite(1))),
    RAT("Rat", 1, 14, List.of(), List.of(new Block(1), new Claw(1))),
    MUSHROOMLIN("Mushroomlin", 1, 20, List.of(), List.of(new Deflect(1), new Scratch(1))),
    MEGA_SAURUS("Mega Saurus", 1, 100, List.of(MonsterType.BOSS),
            List.of(new Bite(2), new Block(2), new Focus<>(2), new Fire(1), new Lightning(1))),
    SNAKE("Snake", 2, 31, List.of(MonsterType.ICE), List.of(new Bite(2), new Focus<>(2), new Ice(2))),
    DARK_ELF("Dark Elf", 2, 34, List.of(), List.of(new Focus<>(2), new Water(1), new Lightning(1))),
    SHADOW_BLADE("Shadow Blade", 2, 27, List.of(MonsterType.LIGHTNING),
            List.of(new Scratch(2), new Focus<>(2), new Lightning(2))),
    HORNET("Hornet", 2, 32, List.of(MonsterType.FIRE),
            List.of(new Scratch(2), new Focus<>(2), new Fire(1), new Fire(2))),
    TARANTULA("Tarantula", 2, 33, List.of(), List.of(new Bite(2), new Block(2), new Scratch(2))),
    BEAR("Bear", 2, 40, List.of(), List.of(new Claw(2), new Deflect(2), new Block(2))),
    MUSHROOMLON("Mushroomlon", 2, 50, List.of(), List.of(new Deflect(2), new Scratch(2), new Block(2))),
    WILD_BOAR("Wild Boar", 2, 27, List.of(), List.of(new Scratch(2), new Deflect(2), new Scratch(2)));


    private final Monster monster;

    Monsters(final String name, final int level, final int lifePoints, List<MonsterType> monsterTypes,
             List<Ability<Monster, Player>> monsterAbilites) {
        this.monster = new Monster(name, lifePoints, monsterTypes, monsterAbilites, level);
    }

    public Monster getMonster() {
        return monster;
    }
}
