package edu.kit.informatik.ui.prompts;

import java.util.List;

/**
 * The interface Prompt.
 *
 * @param <T> the type parameter
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public interface Prompt<T> {

    /**
     * FIRST_ORDINAL of a prompt
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
     * @return input arguments
     */
    List<T> parseList();
    // TODO: 15.03.22 add that maxOrdinal is inclusive

    /**
     * Parse item t.
     *
     * @return the t
     */
    T parseItem();


}
