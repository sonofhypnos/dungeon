package edu.kit.informatik.model.states;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.MonsterType;
import edu.kit.informatik.model.Cards.Monsters;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.GameContext;

import edu.kit.informatik.ui.OutputInterFace;
import edu.kit.informatik.ui.prompts.PrintStatus;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class FightingLevel implements GameState {
    private static final int INITIAL_LEVEL = 1;
    private static final int INITIAL_STAGE = 1;
    private static final int STAGE_NUMBER = 4;
    private int stage;
    private int level;
    private final GameContext runa;
    private List<Monster> currentMonsters;
    private GameState currentGamestate;
    private Player player;
    private OutputInterFace interFace;

    public FightingLevel(GameContext runa) {
        this.runa = runa;
        this.player = runa.getPlayer();
        this.stage = INITIAL_STAGE;
        this.level = INITIAL_LEVEL;
    }

    public void setCurrentGamestate(final GameState currentGamestate) {
        this.currentGamestate = currentGamestate;
    }

    @Override
    public void prompt() {
        // TODO: 10.03.22 check if won/lost
        // TODO: 11.03.22 make a state to initialize Fight?

        startFight();
        currentGamestate = new Turn(this);
        this.currentGamestate.prompt();
    }

    @Override
    public void run(final String input, final GameContext runa) {
        // TODO: 11.03.22 figure out how we now which monsters are fighting?

    }


    private void startFight() {
        if (runa.getStage() == 4) {
            currentMonsters = Arrays.stream(Monsters.values())
                    .map(Monsters::getMonster) //Map enums to contained monsters
                    .filter((Monster m) -> m.isType(MonsterType.BOSS) && m.getLevel() == runa.getLevel())
                    .collect(Collectors.toList());
        }
        if (runa.getStage() == 1) {
            this.runa.shuffle();
            currentMonsters = this.runa.drawMonster(1);
        } else {
            currentMonsters = this.runa.drawMonster(2);
        }
        this.interFace = new OutputInterFace();
        interFace.printStage(runa.getPlayer() , runa.getStage(), runa.getLevel());
        interFace.printStatus();

        // TODO: 14.03.22 Update of abilities comes with prompt and only after boss level the second time around
    }


    public Player getPlayer() {
        return player;
    }

    public List<Monster> getCurrentMonsters() {
        return currentMonsters;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(final int level) {
        this.level = level;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(final int stage) {
        this.stage = stage;
    }
}
