/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

package edu.kit.informatik;

import edu.kit.informatik.model.GameInitializer;
import edu.kit.informatik.ui.Session;
import edu.kit.informatik.ui.prompts.Quit;

/**
 * The Application. Creates the needed instances and runs the interactive command session.
 * 
 * @author Moritz Hertler
 * @version 1.0
 */
public final class Application {

    private static final String ERROR_UTILITY_CLASS_INSTANTIATION = "Utility class cannot be instantiated.";

    private static final String ILLEGAL_NAME_CHARS = " ";

    
    private Application() {
        throw new AssertionError(ERROR_UTILITY_CLASS_INSTANTIATION);
    }

    /**
     * The main entry point to the application.
     * 
     */
    public static void main(String[] args) {

        GameInitializer game = new GameInitializer();
        // TODO: 10.03.22 Add check for 0 arguments
        // TODO: 10.03.22 check what kinds of input/output is allowed.
        // TODO: 10.03.22 make sure there is no final \n when exiting?

        System.out.println("Welcome to Runa's Strive");
        Session session = new Session(game);
        session.addCommand(new Quit(session));
        session.start();
    }
}
