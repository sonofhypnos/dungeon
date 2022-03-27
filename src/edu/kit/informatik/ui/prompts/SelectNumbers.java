package edu.kit.informatik.ui.prompts;

import java.util.List;

import static java.lang.Integer.MAX_VALUE;

/**
 * Select Numbers Prompt. Difference to Selectprompt is that it does not list any options, since we actually want a
 * number from the user.
 *
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class SelectNumbers extends SelectPrompt<Integer> {

    private static final String PROMPT_DELIMITER = "%n";
    private final String separator;
    private final int optionNumber;


    /**
     * Instantiates a new Select numbers prompt
     *
     * @param text           the text
     * @param entryPrompt    the entry prompt
     * @param maxOrdinal     the max ordinal
     * @param optionNumber   the option number
     * @param separatorRegex the separator regex
     */
    public SelectNumbers(final String text, final String entryPrompt, final int maxOrdinal, int optionNumber,
                         final String separatorRegex) {
        super(text, entryPrompt, maxOrdinal);
        this.separator = separatorRegex;
        this.optionNumber = optionNumber;
    }

    @Override
    public void prompt() {
        interFace.println(text);
    }

    @Override
    public void entryPrompt() {
        interFace.println(String.format((this.entryPrompt), FIRST_ORDINAL, MAX_VALUE));
    }

    @Override
    public List<Integer> parseList() {
        return getIntegers(separator, maxOrdinal, optionNumber, optionNumber);
    }
}
