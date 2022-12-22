package edu.kit.informatik.ui.prompts;

import edu.kit.informatik.ui.Terminal;

import java.util.List;

import static java.lang.Integer.MAX_VALUE;

/**
 * Select Numbers Prompt. Difference to Select prompt is that it does not list any options, since we actually want a
 * number from the user.
 *
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class SelectNumbers extends SelectPrompt<Integer> {

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
     * @param noDuplicates   the no duplicates
     */
    public SelectNumbers(final String text, final String entryPrompt, final int maxOrdinal, int optionNumber,
                         final String separatorRegex, boolean noDuplicates) {
        super(text, entryPrompt, maxOrdinal, noDuplicates);
        this.separator = separatorRegex;
        this.optionNumber = optionNumber;
    }

    @Override
    public void prompt() {
        Terminal.println(getText());
    }

    @Override
    public void entryPrompt() {
        Terminal.println(String.format(getEntryPrompt(), 1, MAX_VALUE));
    }

    @Override
    public List<Integer> parseList() {
        return getIntegers(separator, super.getMaxOrdinal(), optionNumber, optionNumber);
    }
}
