package edu.kit.informatik.ui.prompts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class SelectPrompts<T> extends SelectPrompt<T> {

    private static final String ENTER_NUMBERS = "Enter numbers [1--<n>] separated by comma:";
    private static final String SEPARATOR_REGEX = ",";
    private final String separator;

    /**
     * Instantiates a new Select prompt.
     *
     * @param text    the text
     * @param options the options
     */
    public SelectPrompts(final String text, final List<T> options) {
        super(text, options, ENTER_NUMBERS);
        this.separator = SEPARATOR_REGEX;
    }

    public SelectPrompts(final String text, final String entryPrompt, final List<T> options, String separator) {
        super(text, options, entryPrompt);
        this.separator = separator;
    }

    @Override
    public List<T> parse(final String input) {
        List<Integer> args;
        try {
            args = Arrays.stream(input.split(separator)).map(Integer::parseUnsignedInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            return null;
        }
        if (args.stream().anyMatch(i -> i < FIRST_ORDINAL || i > this.maxOrdinal))
            return null;

        return args.stream().map(options::get).collect(Collectors.toList());
    }
}
