/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

package edu.kit.informatik.model.states;

import edu.kit.informatik.model.GameInitializer;
import edu.kit.informatik.model.exception.GameStateException;

/**
 * A game state.
 * <p>
 * All game states used in the orlog state machine have to implement this interface.
 * All method throw a {@link GameStateException} by default.
 *
 * @author upkim
 * @version 1.0
 */
public interface GameState {

    /**
     * Prompt.
     */
    void prompt();

    /**
     * Run.
     *
     * @param input the input
     * @param runa
     */
    void run(String input, final GameInitializer runa);

}
















































