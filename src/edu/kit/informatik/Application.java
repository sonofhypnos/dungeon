/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

package edu.kit.informatik;

import edu.kit.informatik.model.Runa;
import edu.kit.informatik.ui.ScannerSingleton;

/**
 * The Application. Creates the needed instances and runs the interactive command session.
 * 
 * @author upkim
 * @version 1.0 17-03-2022
 */
public final class Application {

    private static final String ERROR_UTILITY_CLASS_INSTANTIATION = "Utility class cannot be instantiated.";
    private static final int ARGUMENT_NUMBER = 0;
    private static final String ERROR_GAME_DOES_NOT_EXPECT_ANY_ARGUMENTS = "Error, Game does not expect any arguments";


    private Application() {
        throw new AssertionError(ERROR_UTILITY_CLASS_INSTANTIATION);
    }

    /**
     * The main entry point to the application.
     * @param args input arguments
     */
    public static void main(String[] args) {

        // TODO: 10.03.22 Add check for 0 arguments
        // TODO: 10.03.22 check what kinds of input/output is allowed.
        // TODO: 10.03.22 make sure there is no final \n when exiting?

        // TODO: 15.03.22 figure out if this is too much?
        if (args.length != ARGUMENT_NUMBER) {
            throw new IllegalArgumentException(ERROR_GAME_DOES_NOT_EXPECT_ANY_ARGUMENTS);
        }
        Runa game = new Runa();
        game.runGame();
        ScannerSingleton.closeInstance();
    }
}
