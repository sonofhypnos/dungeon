package edu.kit.informatik.model.states;

import edu.kit.informatik.model.GameContext;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class Level implements GameState {
    private GameState currentStage;
    int Stage;

    public Level(final int initialLevel) {
    }

    @Override
    public void prompt() {

    }

    @Override
    public void run(final String input, final GameContext gameInitializer) {

    }
}
