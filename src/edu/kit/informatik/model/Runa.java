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
import edu.kit.informatik.model.abilities.effects.rewards.NewDice;
import edu.kit.informatik.model.abilities.player.PlayerAbilities;
import edu.kit.informatik.ui.OutputInterFace;
import edu.kit.informatik.ui.prompts.DiceRoll;
import edu.kit.informatik.ui.prompts.Prompt;
import edu.kit.informatik.ui.prompts.SeedPrompt;
import edu.kit.informatik.ui.prompts.SelectPrompt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Runa class. Runs the logic of the Runa game. We decided to not use game states like the example solution of
 * assignment 5, because without commands the game flow was very linear (At every decision-point of the user it is clear
 * what the user is allowed to do (which is inputting Integers from 1 to n) as opposed to commands where it might be
 * rather complicated to figure out whether the input was valid, so it would have made more sense to allow for a
 * modular "gameflow" with explicit states.
 *
 * @author upkim
 * @version 1.0
 */
public class Runa {
    // TODO: 26.03.22 make sure there are no getter functions that can change somethign about an object
    private static final int MIN_CARDS = 1;
    private static final int INITIAL_LEVEL = 1;
    private static final int BOSS_STAGE = 4;
    private static final int SEED_NUMBER = 2;
    private static final int MAX_LEVEL = 2;
    private static final String SELECT_PLAYER_S_CHARACTER_CLASS = "Select %s's character class";
    private static final String SELECT_CARD_TO_PLAY = "Select card to play";
    private static final int INITIAL_STAGE = 1;
    private static final int HEAL_PER_CARD = 10;
    private static final int CARD_POOL_MULTIPLE = 2;
    private static final String PLAYER_NAME = "Runa";
    private final PlayerDeck playerDeck = new PlayerDeck();
    private final Player player;
    private final OutputInterFace interFace;
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
        interFace = new OutputInterFace();
        interFace.welcome();
    }

    /**
     * Gets player.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    // TODO: 25.03.22 alternative approach to try: Create gamestates again: each gamestate also takes in the session
    //  and sets the prompt for the session. The session in turn uses the parseInt and parseInteger functions from
    //  the Sheet to decide whether to parse Input.

    /**
     * Runs the main logic of the game.
     */
    public void runGame() {
        Prompt<Archetype> archetypePrompt = new SelectPrompt<>(
                String.format(SELECT_PLAYER_S_CHARACTER_CLASS, player.getName()), List.of(Archetype.values()));
        // TODO: 25.03.22 add justification for not using gameStates: while my approach has the downside of having to
        //  use return statements everywhere, the state-approach has the downside of basically being an awkward goto
        //  (add justification)

        var archetyp = archetypePrompt.parseItem();
        // TODO: 25.03.22 add stuff about code repetition
        if (!SelectPrompt.isRunning()) {
            return;
        }
        this.player.setClass(archetyp); //done
        for (var card : player.getStartingCards()) {
            playerDeck.remove(card.getAbility());
        }
        for (int level = INITIAL_LEVEL; level < MAX_LEVEL + INITIAL_LEVEL; level++) {
            SeedPrompt prompt = new SeedPrompt(SEED_NUMBER);
            var seeds = prompt.parseList();
            if (!SelectPrompt.isRunning()) {
                return;
            }
            // TODO: 26.03.22 add message about card update (maybe even include initial stage
            shuffle(seeds, level);
            fight(level);
            if (this.lost) {
                lost();
                break;
            }
        }
        if (!this.lost) {
            interFace.won(player);
            // TODO: 26.03.22 initialisiere die Fähigkeitskarten des Spielers bei 1
        }
    }

    // TODO: 18.03.22 implement message 0 damage

    private void fight(int level) {
        for (int stage = INITIAL_STAGE; stage < BOSS_STAGE + INITIAL_STAGE; stage++) {
            startFight(stage, level);
            while (SelectPrompt.isRunning()) {
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
            if (stage == BOSS_STAGE && level != MAX_LEVEL) {
                final int newLevel = level + 1;
                player.upgradeCards(newLevel);
                player.getStartingCards()
                        .forEach((PlayerAbilities x) -> interFace.getCard(player, x.getLevel(newLevel)));
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
            //It is assumed that there is alway
            do {
                monsterAbility = monster.activateNextAbility();
            } while (!monsterAbility.canBeUsed(monster));
            interFace.printUsage(monster, monsterAbility);
            monsterAbility.applyEffect(monster, player);
            if (player.isDead()) {
                return;
            }
        }

        evalFocus(player);
    }

    private void playerTurn() {
        player.reset();
        var abilityPrompt = new SelectPrompt<>(SELECT_CARD_TO_PLAY, player.getHand());
        var ability = abilityPrompt.parseItem();

        if (!SelectPrompt.isRunning()) {
            return;
        }
        // TODO: 25.03.22 explain conflict between object-orientation, separating ui and model and not using the exit
        //  command
        // TODO: 25.03.22 add that this was previously just put into the functions themselves (polymorphism), but
        //  this had the issue of needing to communicate put sideeffects through chain, which was awkward
        Monster target = null;
        if (ability.isType(AbilityType.OFFENSIVE)) {
            target = interFace.getTarget(player, currentMonsters);
            if (!SelectPrompt.isRunning()) {
                return;
            }
            // TODO: 26.03.22 find pretty solution for diceRoll

        }
        interFace.printUsage(player, ability);
        if (ability.needsDice()) {
            Prompt<Integer> dicePrompt = new DiceRoll(player.getDice());
            Integer roll = dicePrompt.parseItem();
            if (!SelectPrompt.isRunning()) {
                return;
            }
            ability.setRoll(roll);
            // TODO: 26.03.22 target should come before the dice throw
            // TODO: 25.03.22 can I write stuff like the above?
        }
        ability.applyEffect(player, target);

        currentMonsters = currentMonsters.stream().filter((Monster m) -> !m.isDead())
                .collect(Collectors.toList()); // TODO: 26.03.22 this might not need to be done here(is done in apply
        // effect (which also might be unnecessary??

        for (Monster monster : currentMonsters) {
            evalFocus(monster);
        }
    }

    private void evalFocus(final Agent<?, ?> agent) {
        int focusPoints = agent.evalFocus();
        interFace.focus(agent, focusPoints);
    }

    private void lost() {
        interFace.dies(player);
    }


    private void healing() {
        if (player.getHealthPoints() != player.getMaxHealth() && player.getHand().size() > MIN_CARDS) {
            // TODO: 18.03.22 remove if none?
            // TODO: 18.03.22 remove vars in code
            var cardToRemove = interFace.heal(player);
            if (!SelectPrompt.isRunning()) {
                return;
            }

            final int healthPrev = player.getHealthPoints();

            player.heal(HEAL_PER_CARD * cardToRemove.size());
            interFace.printHeal(player, player.getHealthPoints() - healthPrev);
            for (var card : cardToRemove) {
                player.removeCard(card);
            }
        }
    }

    private void collectRewards() {
        List<Effect<Player, Monster>> rewards = new ArrayList<>(List.of());
        if (this.playerDeck.size() != 0) {
            rewards.add(new NewAbilityCards(playerDeck, monsterNumber, CARD_POOL_MULTIPLE * monsterNumber, this));
        }
        if (!this.player.getDice().isLast()) {
            rewards.add(new NewDice());
        }
        Prompt<Effect<Player, Monster>> rewardPrompt = new SelectPrompt<>(String.format("Choose %s's reward", player),
                rewards);
        Effect<Player, Monster> reward = rewardPrompt.parseItem();
        if (!SelectPrompt.isRunning()) {
            return;
        }
        reward.applyEffect(player, null);
    }


    // TODO: 26.03.22 dont forget todos in emacs scratchpad!
    private void startFight(final int stage, final int level) {
        if (stage == 4) {
            currentMonsters = getBoss(level);
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

    private List<Monster> getBoss(final int level) {
        return Arrays.stream(Monsters.values()).map(Monsters::getMonster) //Map enums to contained monsters
                .filter((Monster m) -> m.isType(MonsterType.BOSS) && m.getLevel() == level)
                .collect(Collectors.toList());
    }


    private void shuffle(List<Integer> seeds, int level) {
        // TODO: 26.03.22 make sure the cards from runa's class are not included!
        monsterDeck = new MonsterDeck(level);
        playerDeck.shuffle(seeds.get(0));
        monsterDeck.shuffle(seeds.get(1));
    }
}
