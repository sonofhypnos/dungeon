package edu.kit.informatik.ui.prompts;

import java.util.List;

/**
 * The output Prompt.
 *
 * @param <T> the type parameter
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public interface Prompt<T> {



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

    /**
     * Parse item t.
     *
     * @return the t
     */
    T parseItem();


}
