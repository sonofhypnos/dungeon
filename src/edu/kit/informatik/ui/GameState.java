package edu.kit.informatik.ui;

import edu.kit.informatik.ui.prompts.Prompt;

/**
 * @author upkim
 * @version 1.0.0 2022-03-18
 */
public abstract class GameState<T> {
    private Prompt<T> prompt;
    private GameState currentGameState;

    protected GameState(Prompt<T> prompt) {
        this.prompt = prompt;
    }


    public abstract GameState run(String input);
    public abstract void prompt();
    public abstract void selectPrompt();
}
