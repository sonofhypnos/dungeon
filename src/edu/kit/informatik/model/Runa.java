package edu.kit.informatik.model;

import edu.kit.informatik.model.Cards.*;
import edu.kit.informatik.model.Cards.Player;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.effects.Effect;
import edu.kit.informatik.model.abilities.effects.rewards.newAbilityCards;
import edu.kit.informatik.model.abilities.effects.rewards.newDice;
import edu.kit.informatik.ui.prompts.OutputInterFace;
import edu.kit.informatik.ui.prompts.Prompt;
import edu.kit.informatik.ui.prompts.SeedPrompt;
import edu.kit.informatik.ui.prompts.SelectPrompt;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Moritz Hertler
 * @version 1.0
 */
public class Runa {
    private static final int INITIAL_LEVEL = 1;
    private static final int STAGE_NUMBER = 4;
    private static final int SEED_NUMBER = 2;
    private final int stage = INITIAL_LEVEL;
    private final int MAX_LEVEL = 2;
    /**
     * The constant PLAYER.
     */
    private final PlayerDeck playerDeck = new PlayerDeck();
    private final Player player;
    private List<Monster> currentMonsters;
    private OutputInterFace outPutInterface;
    private List<Integer> seeds;
    private MonsterDeck monsterDeck;



    private static final String SELECT_PLAYER_S_CHARACTER_CLASS = "Select %s's character class";
    private static final String SELECT_CARD_TO_PLAY = "Select Card to play";
    private int monsterNumber;

    public Runa() {
        player = new Player("Runa");
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * Process.
     */
    public void run() {
        //character
        Prompt<Archetype> archetypePrompt = new SelectPrompt<>(
                String.format(SELECT_PLAYER_S_CHARACTER_CLASS, player.getName()), List.of(Archetype.values()));
        this.player.setClass(archetypePrompt.parseItem());
        setPlayerCardLevel(INITIAL_LEVEL);
        //seed
        Prompt<Integer> prompt = new SeedPrompt(SEED_NUMBER);
        for (int level = INITIAL_LEVEL; level <= MAX_LEVEL; level++) {
            shuffle(prompt.parseList(), level);
            fight(level);
        }
    }

    private void fight(int level) {
        for (int stage = 0; stage < STAGE_NUMBER; stage++) {
            startFight(stage, level);

            while (true) {
                
                outPutInterface.printStatus(player, currentMonsters);
                //runas turn

                player.reset();
                
                
                
                Prompt<Ability<Player, List<Monster>>> abilityPrompt = new SelectPrompt<>(SELECT_CARD_TO_PLAY, player.getCards());
                Ability<Player, List<Monster>> ability = abilityPrompt.parseItem();
                outPutInterface.printUsage(player, ability);
                ability.applyEffect(player, currentMonsters);
                
                //focus monster
                for (Monster monster : currentMonsters) {
                    monster.evalFocus();
                }
                //end runa's turn

                // TODO: 17.03.22 need to check first if monster is alive?
                // TODO: 17.03.22 give message if monster dies
                //remove dead monsters
                currentMonsters = currentMonsters.stream().filter((Monster m) -> !m.isDead()).collect(Collectors.toList());

                if (currentMonsters.isEmpty()) {
                    break;
                }
                //monster
                for (Monster monster : currentMonsters) {
                    Ability<Monster, Player> monsterAbility = monster.activateNextAbility();
                    outPutInterface.printUsage(monster, monsterAbility);
                    monsterAbility.applyEffect(monster, player);
                }

                // 17.03.22 check focus points player
                player.evalFocus();
                // TODO: 17.03.22 invalidate stuff at the end of turn
            }

            // TODO: 17.03.22 add one subfunction for every stage in the figure

            // TODO: 17.03.22 check if runa dies

            //end of round
            // TODO: 17.03.22 implement if lost / won


            // TODO: 17.03.22 implement between stages
            //2.4.1
            collectRewards();


            //2.4.2


            //2.4.3
            //2.4.4

        }




        // TODO: 17.03.22  implement upgrade
        // // TODO: 17.03.22 implement new cards/dice


        // TODO: 17.03.22 implement healing
        // TODO: 17.03.22 implement between levels
    }

    private void collectRewards() {
        List<Effect<Player, Monster>> rewards = new ArrayList<>(List.of(
                new newAbilityCards(this.playerDeck, this.monsterNumber)));
        if (!this.player.getDice().isLast()) {
            rewards.add(new newDice());
        }
        Prompt<Effect<Player, Monster>> rewardPrompt = new SelectPrompt<>(String.format("Choose %s's reward", player),
                rewards);
        Effect<Player, Monster> reward = rewardPrompt.parseItem();
        reward.applyEffect(player, null);
    }


    private void startFight(int stage, int level) {
        int monsterNumber;
        if (stage == 1) {
            monsterNumber = 1;
            // TODO: 16.03.22 make new function for start level?
        } else {
            monsterNumber = 2;
        }
        currentMonsters = this.monsterDeck.draw(monsterNumber);
        this.monsterNumber = monsterNumber;

        this.outPutInterface = new OutputInterFace();
        outPutInterface.printStage(player, stage, level);
        // TODO: 14.03.22 Update of abilities comes with prompt and only after boss level the second time around
    }

    private void setPlayerCardLevel(int level) {
        for (Ability<?,?> card: player.getStartingCards() ) {
            card.setLevel(level);
        }
    }


    public void shuffle(List<Integer> seeds, int level) {
        monsterDeck = new MonsterDeck(level);
        playerDeck.shuffle(seeds.get(0));
        monsterDeck.shuffle(seeds.get(1));
    }

}
