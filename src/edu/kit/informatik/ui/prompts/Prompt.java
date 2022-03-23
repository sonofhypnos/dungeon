package edu.kit.informatik.ui.prompts;

import edu.kit.informatik.model.Cards.Dice;
import edu.kit.informatik.model.exception.ParseException;

import java.util.List;

/**
 * The interface Prompt.
 *
 * @param <T> the type parameter
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public interface Prompt <T> {

    /**
     * The constant FIRST_ORDINAL.
     */
    int FIRST_ORDINAL = 1;

    /**
     * Prompt.
     */
    void prompt();

    /**
     * Entry prompt.
     */
    void entryPrompt();

    /**
     * Parse list.
     *
     * @param input the input
     * @return the list
     * @throws ParseException the parse exception
     */
    T parse(String input);
}
