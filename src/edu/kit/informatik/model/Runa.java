package edu.kit.informatik.model;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.MonsterDeck;
import edu.kit.informatik.model.Cards.MonsterType;
import edu.kit.informatik.model.Cards.Monsters;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Cards.PlayerDeck;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.abilities.effects.Effect;
import edu.kit.informatik.model.abilities.effects.rewards.NewAbilityCards;
import edu.kit.informatik.model.abilities.effects.rewards.NewDie;
import edu.kit.informatik.ui.Terminal;
import edu.kit.informatik.ui.prompts.DiceRoll;
import edu.kit.informatik.ui.prompts.Prompt;
import edu.kit.informatik.ui.prompts.SeedPrompt;
import edu.kit.informatik.ui.prompts.SelectPrompt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Runa class. Runs the logic of the Runa game. We decided to not use game states like the example solution of
 * assignment 5, because without commands the game flow was very linear (At every decision-point of the user it is clear
 * what the user is allowed to do (which is input Integers from 1 to n) as opposed to commands where it might be
 * rather complicated to figure out whether the input was valid, so it would have made more sense to allow for a
 * modular "gameflow" with explicit states.
 *
 * @author upkim
 * @version 1.0
 */
public class Runa {
    private static final int MIN_CARDS = 1;
    private static final int INITIAL_LEVEL = 1;
    private static final int BOSS_STAGE = 4;
    private static final int SEED_NUMBER = 2;
    private static final int MAX_LEVEL = 2;
    private static final int INITIAL_STAGE = 1;
    private static final int INITIAL_STAGE_MONSTER_NUMBER = 1;
    private static final int HEAL_PER_CARD = 10;
    private static final int CARD_POOL_MULTIPLE = 2;
    private static final int DEFAULT_MONSTER_NUMBER = 2;

    private static final String PLAYER_NAME = "Runa";
    private static final String SELECT_PLAYER_S_CHARACTER_CLASS = "Select %s's character class";
    private static final String SELECT_CARD_TO_PLAY = "Select card to play";
    private static final String CHOOSE_S_S_REWARD = "Choose %s's reward";
    private final PlayerDeck playerDeck = new PlayerDeck();
    private final Player player;
    private List<Monster> currentMonsters;
    private MonsterDeck monsterDeck;
    private int monsterNumber;
    private boolean lost;

    /**
     * Instantiates a new Runa. game
     */
    public Runa() {
        player = new Player(PLAYER_NAME);
        this.lost = false;
        Terminal.welcome();
    }

    /**
     * Gets player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Starts the Runa game.
     */
    public void runGame() {
        initGame();
        for (int level = INITIAL_LEVEL; level < MAX_LEVEL + INITIAL_LEVEL; level++) {
            SeedPrompt prompt = new SeedPrompt(SEED_NUMBER);
            var seeds = prompt.parseList();
            if (!SelectPrompt.isRunning()) {
                return;
            }
            shuffle(seeds, level);
            fight(level);
            if (this.lost) {
                lost();
                break;
            }
        }
        if (!this.lost) {
            Terminal.won(player);
        }
    }

    private void initGame() {
        Prompt<Archetype> archetypePrompt = new SelectPrompt<>(
                String.format(SELECT_PLAYER_S_CHARACTER_CLASS, player.getName()), List.of(Archetype.values()));
        Archetype archetype = archetypePrompt.parseItem();
        if (!SelectPrompt.isRunning()) {
            return;
        }
        this.player.setClass(archetype);
        for (var card : player.getStartingCards()) {
            playerDeck.remove(card.getAbility());
        }
    }

    private void fight(int level) {
        for (int stage = INITIAL_STAGE; stage < BOSS_STAGE + INITIAL_STAGE; stage++) {
            startFight(stage, level);
            while (SelectPrompt.isRunning()) {
                Terminal.printStatus(player, currentMonsters);
                playerTurn(level, stage);
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
            if (stage == BOSS_STAGE && level != MAX_LEVEL) {
                final int newLevel = level + 1;
                player.upgradeCards(newLevel);
                for (var card : player.getStartingCards()) {
                    Terminal.getCard(player, card.getLevel(newLevel));
                }
            } else {
                collectRewards();
            }
            healing();
        }
    }

    private void monsterTurn() {
        for (Monster monster : currentMonsters) {
            monster.reset();
            Ability<Monster, Player> monsterAbility;
            do {
                monsterAbility = monster.activateNextAbility();
            } while (!monsterAbility.canBeUsed(monster));
            Terminal.printUsage(monster, monsterAbility);
            monsterAbility.applyEffect(monster, player);
            if (monster.isDead()) {
                Terminal.dies(monster);
            }
            if (player.isDead()) {
                return;
            }
        }

        currentMonsters = removeDeadMonsters();

        evalFocus(player);
    }

    private List<Monster> removeDeadMonsters() {
        return currentMonsters.stream().filter((Monster m) -> !m.isDead()).collect(Collectors.toList());
    }

    private void playerTurn(int level, final int stage) {
        player.reset();
        var abilityPrompt = new SelectPrompt<>(SELECT_CARD_TO_PLAY, player.getHand(), true);
        var ability = abilityPrompt.parseItem();

        if (!SelectPrompt.isRunning()) {
            return;
        }
        Monster target = null;
        if (ability.isType(AbilityType.OFFENSIVE)) {
            target = Terminal.getTarget(player, currentMonsters);
            if (!SelectPrompt.isRunning()) {
                return;
            }
        }
        Terminal.printUsage(player, ability);
        if (ability.needsDice()) {
            Prompt<Integer> dicePrompt = new DiceRoll(player.getDice());
            Integer roll = dicePrompt.parseItem();
            if (!SelectPrompt.isRunning()) {
                return;
            }
            ability.setRoll(roll);
        }
        ability.applyEffect(player, target);
        if (target != null && target.isDead()) {
            Terminal.dies(target);
            currentMonsters.remove(target);
        }

        if (currentMonsters.isEmpty() && level == MAX_LEVEL && stage == BOSS_STAGE) {
            Terminal.won(player);
            SelectPrompt.stopRunning();
        }


        for (Monster monster : currentMonsters) {
            evalFocus(monster);
        }
    }

    private <A extends Agent> void evalFocus(final A agent) {
        int focusPoints = agent.evalFocus();
        Terminal.focus(agent, focusPoints);
    }

    private void lost() {
        Terminal.dies(player);
    }


    private void healing() {
        if (player.getHealthPoints() != player.getMaxHealth() && player.getHand().size() > MIN_CARDS) {
            var cardToRemove = Terminal.heal(player, HEAL_PER_CARD);
            if (!SelectPrompt.isRunning()) {
                return;
            }

            final int healthPrev = player.getHealthPoints();

            player.heal(HEAL_PER_CARD * Objects.requireNonNull(cardToRemove).size());
            Terminal.printHeal(player, player.getHealthPoints() - healthPrev);
            for (var card : cardToRemove) {
                player.removeCard(card);
            }
        }
    }

    private void collectRewards() {
        List<Effect<Player, Monster>> rewards = new ArrayList<>(List.of());
        if (this.playerDeck.size() != 0) {
            rewards.add(new NewAbilityCards(playerDeck, monsterNumber, CARD_POOL_MULTIPLE * monsterNumber));
        }
        if (!this.player.getDice().isLast()) {
            rewards.add(new NewDie());
        }
        Prompt<Effect<Player, Monster>> rewardPrompt = new SelectPrompt<>(String.format(CHOOSE_S_S_REWARD, player),
                rewards);
        Effect<Player, Monster> reward = rewardPrompt.parseItem();
        if (!SelectPrompt.isRunning()) {
            return;
        }
        reward.applyEffect(player, null);
    }


    private void startFight(final int stage, final int level) {
        if (stage == BOSS_STAGE) {
            currentMonsters = getBoss(level);
        } else {
            if (stage == INITIAL_STAGE) {
                monsterNumber = INITIAL_STAGE_MONSTER_NUMBER;
            } else {
                monsterNumber = DEFAULT_MONSTER_NUMBER;
            }
            currentMonsters = this.monsterDeck.draw(monsterNumber);
        }
        monsterNumber = currentMonsters.size();
        Terminal.printStage(player, stage, level);
    }

    private List<Monster> getBoss(final int level) {
        List<Monster> bossList = new ArrayList<>();
        for (Monsters monsterEnum : Monsters.values()) {
            Monster newMonster = monsterEnum.getMonster();
            if (newMonster.isType(MonsterType.BOSS) && newMonster.getLevel() == level) {
                bossList.add(newMonster);
            }
        }
        return bossList;
    }

    private void shuffle(List<Integer> seeds, int level) {
        monsterDeck = new MonsterDeck(level);
        playerDeck.shuffle(seeds.get(0));
        monsterDeck.shuffle(seeds.get(1));
    }
}
