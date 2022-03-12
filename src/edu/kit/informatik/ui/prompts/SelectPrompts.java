package edu.kit.informatik.ui.prompts;

import edu.kit.informatik.model.exception.ParseException;
import edu.kit.informatik.ui.resources.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class SelectPrompts<T> extends SelectPrompt<T> {

    private static final String ENTER_NUMBERS = "Enter numbers [1--<n>] separated by comma:";
    private static final String REGEX = ",";

    /**
     * Instantiates a new Select prompt.
     *
     * @param text    the text
     * @param options the options
     */
    public SelectPrompts(final String text, final List<T> options) {
        super(text, options, ENTER_NUMBERS);
    }

    @Override
    public List<T> parse(final String input) {
        List<Integer> args;
        try {
            args = Arrays.stream(input.split(REGEX)).map(Integer::parseUnsignedInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            return null;
        }
        if (args.stream().anyMatch(i -> i < FIRST_ORDINAL || i > this.maxOrdinal))
            return null;

        return args.stream().map(options::get).collect(Collectors.toList());
    }
}
