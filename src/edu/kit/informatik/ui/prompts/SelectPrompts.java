package edu.kit.informatik.ui.prompts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class SelectPrompts<T> implements Prompt<List<T>> {
    private static final String ENTER_NUMBERS = "Enter numbers [1--<n>] separated by comma:";
    private static final String REGEX = ",";
    private String text;
    private List<T> options;
    private int minSelect;
    private int maxSelect;

    /**
     * Instantiates a new Select prompt.
     *
     * @param text    the text
     * @param options the options
     */
    public SelectPrompts(final String text, final List<T> options) {
        this.text = text;
        this.options = options;
    }

    public SelectPrompts(final String text, final List<T> options, final int minSelect,
                         final int maxSelect) {
        this.text = text;
        this.options = options;
        this.minSelect = minSelect;
        this.maxSelect = maxSelect;
    }

    @Override
    public void prompt() {
        System.out.println(ENTER_NUMBERS);
    }

    @Override
    public void entryPrompt() {

    }

    @Override
    public List<T> parse(final String input) {
        List<Integer> args;
        try {
            args = Arrays.stream(input.split(REGEX)).map(Integer::parseUnsignedInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            return null;
        }
        if (args.stream().anyMatch(i -> i < FIRST_ORDINAL || i > this.options.size()))
            return null;

        return args.stream().map((Integer x) -> options.get(x - 1)).collect(Collectors.toList());
    }
}
