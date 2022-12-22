package edu.kit.informatik;

import edu.kit.informatik.model.Runa;
import edu.kit.informatik.ui.ScannerSingleton;

/**
 * The Application. Creates instance of the game and runs it.
 *
 * @author upkim
 * @version 1.0 17-03-2022
 */
public final class Application {

    private static final String ERROR_UTILITY_CLASS_INSTANTIATION = "Error, Utility class cannot be instantiated.";
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
        if (args.length != ARGUMENT_NUMBER) {
            System.err.println(ERROR_GAME_DOES_NOT_EXPECT_ANY_ARGUMENTS);
        } else{
            Runa game = new Runa();
            game.runGame();
            ScannerSingleton.closeInstance();
        }

    }
}
