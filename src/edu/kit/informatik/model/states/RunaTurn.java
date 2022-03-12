package edu.kit.informatik.model.states;

import edu.kit.informatik.model.Runa;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class RunaTurn implements GameState {

    private final Runa runa;

    public RunaTurn(final Runa runa) {
        this.runa = runa;
    }

    @Override
    public void prompt() {

    }

    @Override
    public void run(final String input, final Runa runa) {

    }
}
