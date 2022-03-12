package edu.kit.informatik.model.states;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Runa;

import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class FightingLevel implements GameState {
    private static final int INITIAL_LEVEL = 1;
    private static final int STAGES = 4;
    private final Runa runa;
    private final int stage = INITIAL_LEVEL;
    private final int level = INITIAL_LEVEL;
    private List<Monster> currentMonster;
    private GameState currentGamestate;

    public FightingLevel(Runa runa) {
        this.runa = runa;
        this.currentGamestate = new RunaTurn(runa);
    }

    public void setCurrentGamestate(final GameState currentGamestate) {
        this.currentGamestate = currentGamestate;
    }

    @Override
    public void prompt() {
        // TODO: 10.03.22 check if won/lost
        // TODO: 11.03.22 make a state to initialize Fight?

        startFight();
        this.currentGamestate.prompt();

    }

    @Override
    public void run(final String input, final Runa runa) {
        // TODO: 11.03.22 figure out how we now which monsters are fighting?
    }


    private void startFight() {
        if (this.stage == 1) {
            this.runa.shuffle(level);
            currentMonster = this.runa.drawMonster(1);
        } else {
            currentMonster = this.runa.drawMonster(2);
        }
    }
}
