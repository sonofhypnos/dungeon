/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

package edu.kit.informatik.ui.prompts;

import java.util.List;

import edu.kit.informatik.model.exception.GameStateException;
import edu.kit.informatik.ui.resources.ErrorMessage;

/**
 * A command that handles a {@link GameStateException}. 
 * 
 * @author Moritz Hertler
 * @version 1.0
 */
public abstract class InGameCommand extends Command {

    @Override
    protected void execute(List<String> arguments) {
        try {
            this.executeInGameCommand(arguments);
        } catch (GameStateException e) {
            System.err.println(ErrorMessage.ILLEGAL_GAME_STATE.toString());
        }
    }

    /**
     * The hook all in game commands have to implement.
     * 
     * The {@link GameStateException} is handled by {@link InGameCommand}.
     * 
     * @param arguments the command arguments
     * @throws GameStateException if the game is in an illegal state 
     */
    protected abstract void executeInGameCommand(List<String> arguments) throws GameStateException;
    
}
