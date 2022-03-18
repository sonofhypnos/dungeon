package edu.kit.informatik.model;

import edu.kit.informatik.model.Cards.*;
import edu.kit.informatik.model.Cards.Player;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.effects.Effect;
import edu.kit.informatik.model.abilities.effects.rewards.newAbilityCards;
import edu.kit.informatik.model.abilities.effects.rewards.newDice;
import edu.kit.informatik.ui.OutputInterFace;
import edu.kit.informatik.ui.prompts.Prompt;
import edu.kit.informatik.ui.prompts.QuitException;
import edu.kit.informatik.ui.prompts.SeedPrompt;
import edu.kit.informatik.ui.prompts.SelectPrompt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Moritz Hertler
 * @version 1.0
 */
public class Runa {
    private static final int MIN_CARDS = 1;
    private static final int INITIAL_LEVEL = 1;
    private static final int STAGE_NUMBER = 4;
    private static final int SEED_NUMBER = 2;
    private static final int MAX_LEVEL = 2;
    private static final String SELECT_PLAYER_S_CHARACTER_CLASS = "Select %s's character class";
    private static final String SELECT_CARD_TO_PLAY = "Select card to play";
    private static final int INITIAL_STAGE = 1;
    private static final int HEAL_PER_CARD = 10;
    private final PlayerDeck playerDeck = new PlayerDeck();
    private final Player player;
    private List<Monster> currentMonsters;
    private OutputInterFace interFace;
    private List<Integer> seeds;
    private MonsterDeck monsterDeck;
    private int monsterNumber;
    private boolean lost;

    public Runa() {
        player = new Player("Runa");
        this.lost = false;
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * Process.
     */
    public void runGame() {
        //character
        Prompt<Archetype> archetypePrompt = new SelectPrompt<>(
                String.format(SELECT_PLAYER_S_CHARACTER_CLASS, player.getName()), List.of(Archetype.values()));
        this.player.setClass(archetypePrompt.parseItem());
        setPlayerCardLevel(INITIAL_LEVEL);
        //seed
        SeedPrompt prompt = new SeedPrompt(SEED_NUMBER);
        for (int level = INITIAL_LEVEL; level < MAX_LEVEL + INITIAL_LEVEL; level++) {
            shuffle(prompt.parseList(), level);
            fight(level);
            if (this.lost) {
                lost();
                break;
            }
        }
        interFace.won(player);
    }
    // TODO: 18.03.22 implement message 0 damage

    private void fight(int level) {
        for (int stage = INITIAL_STAGE; stage < STAGE_NUMBER + INITIAL_STAGE; stage++) {
            startFight(stage, level);
            while (true) {
                interFace.printStatus(player, currentMonsters);
                playerTurn();
                if (currentMonsters.isEmpty()) {
                    break;
                }
                monsterTurn();
                if (player.isDead()) {
                    this.lost = true;
                    return;
                }
                if (currentMonsters.isEmpty()) {
                    break;
                }
            }
            collectRewards();
            abilityUpgrade(stage, level);
            healing();
        }
    }

    private void monsterTurn() {
        for (Monster monster : currentMonsters) {
            monster.reset();
            Ability<Monster, Player> monsterAbility = monster.activateNextAbility();
            interFace.printUsage(monster, monsterAbility);
            monsterAbility.applyEffect(monster, player);
        }

        player.evalFocus();
    }

    private void playerTurn() {
        player.reset();
        Prompt<Ability<Player, List<Monster>>> abilityPrompt = new SelectPrompt<>(SELECT_CARD_TO_PLAY,
                player.getCards());
        Ability<Player, List<Monster>> ability = abilityPrompt.parseItem();
        interFace.printUsage(player, ability);
        ability.applyEffect(player, currentMonsters);

        currentMonsters = currentMonsters.stream().filter((Monster m) -> !m.isDead())
                .collect(Collectors.toList());
        for (Monster monster : currentMonsters) {
            monster.evalFocus();
        }
    }

    private void lost() {
        interFace.dies(player);
    }

    private void abilityUpgrade(final int stage, final int level) {
        if (stage == 4) {
            var oldCards = player.getCards().stream().filter((var card) -> player.getStartingCards().contains(card))
                    .collect(Collectors.toList());
            for (var card : oldCards) {
                card.setLevel(level);
                interFace.getCard(player, card);
            }
        }
    }


    private void healing() {
        if (player.getHealthPoints() != player.getMaxHealth() && player.getCards().size() > MIN_CARDS) {
            // TODO: 18.03.22 remove if none?
            // TODO: 18.03.22 remove vars in code
            var healingPrompt = new SelectPrompt<>("", player.getCards(), 0, player.getCards().size() - MIN_CARDS);
            var toRemove = healingPrompt.parseList();
            for (var card : toRemove) {
                player.heal(HEAL_PER_CARD);
                player.removeCard(card);
            }
        }
    }

    private void collectRewards() {
        List<Effect<Player, Monster>> rewards = new ArrayList<>(
                List.of(new newAbilityCards(this.playerDeck, this.monsterNumber)));
        if (!this.player.getDice().isLast()) {
            rewards.add(new newDice());
        }
        Prompt<Effect<Player, Monster>> rewardPrompt = new SelectPrompt<>(String.format("Choose %s's reward", player),
                rewards);
        Effect<Player, Monster> reward = rewardPrompt.parseItem();
        reward.applyEffect(player, null);
    }


    private void startFight(final int stage, final int level) {
        if (stage == 4) {
            currentMonsters = Arrays.stream(Monsters.values())
                    .map(Monsters::getMonster) //Map enums to contained monsters
                    .filter((Monster m) -> m.isType(MonsterType.BOSS) && m.getLevel() == level)
                    .collect(Collectors.toList());
        } else {
            if (stage == 1) {
                monsterNumber = 1;
            } else {
                monsterNumber = 2;
            }
            currentMonsters = this.monsterDeck.draw(monsterNumber);
        }
        monsterNumber = currentMonsters.size();
        interFace.printStage(player, stage, level);
        // TODO: 14.03.22 Update of abilities comes with prompt and only after boss level the second time around
    }

    private void setPlayerCardLevel(int level) {
        for (Ability<?, ?> card : player.getStartingCards()) {
            card.setLevel(level);
        }
    }


    public void shuffle(List<Integer> seeds, int level) {
        monsterDeck = new MonsterDeck(level);
        playerDeck.shuffle(seeds.get(0));
        monsterDeck.shuffle(seeds.get(1));
    }

}
