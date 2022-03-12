/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

package edu.kit.informatik.ui.prompts;

import java.util.List;

import edu.kit.informatik.ui.Session;

/**
 * The quit command.
 * 
 * @author Moritz Hertler
 * @version 1.0
 */
public class Quit extends Command {

    private static final String REGEX = "quit";
    
    private static final int NUMBER_OF_PARAMETERS = 0;

    private final Session session;

    /**
     * Constructs a new quit command. 
     * 
     * @param session the session that will be stopped by this command
     */
    public Quit(Session session) {
        this.session = session;
    }

    @Override
    public String getRegex() {
        return REGEX;
    }

    @Override
    public int getNumberOfParameters() {
        return NUMBER_OF_PARAMETERS;
    }

    @Override
    protected void execute(List<String> arguments) {
        this.session.stop();
    }   
}

