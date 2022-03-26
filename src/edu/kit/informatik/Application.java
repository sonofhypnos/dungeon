/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

package edu.kit.informatik;

import edu.kit.informatik.model.Runa;

/**
 * The Application. Creates the needed instances and runs the interactive command session.
 * 
 * @author upkim
 * @version 1.0 17-03-2022
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

        // TODO: 10.03.22 Add check for 0 arguments
        // TODO: 10.03.22 check what kinds of input/output is allowed.
        // TODO: 10.03.22 make sure there is no final \n when exiting?
        // TODO: 27.03.22  throw excpetions if there are arguments

        // TODO: 15.03.22 figure out if this is too much?
        if (args.length != 0) {
            throw new IllegalArgumentException("Application does not take any arguments");
        }

        System.out.println("Welcome to Runa's Strive"); // TODO: 15.03.22 somewhere?
//        Session session = new Session();
//        session.addCommand(new Quit(session));
//        session.start();
        Runa game = new Runa();
        game.runGame();
    }
}
