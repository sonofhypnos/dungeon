package edu.kit.informatik.ui.prompts;

import edu.kit.informatik.model.exception.ParseException;
import edu.kit.informatik.ui.resources.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Select prompt.
 *
 * @param <T> the type parameter
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class SelectPrompt<T> implements Prompt<T> {


    /**
     * The constant FIRST_ORDINAL.
     */
    private static final String ENTER_PROMPT = "Enter number [%d--%d]:";
    /**
     * The Options.
     */
    List<T> options;
    /**
     * The Max ordinal.
     */
    int maxOrdinal;
    private final String text;
    private final String entryPrompt;
    // TODO: 18.03.22 dürfuen wir überhaupt System.print verwenden?

    /**
     * Instantiates a new Select prompt.
     *
     * @param text    the text
     * @param options the options
     */
    public SelectPrompt(String text, List<T> options) {
        this.text = text;
        this.options = options;
        this.maxOrdinal = options.size() + FIRST_ORDINAL;
        this.entryPrompt = String.format(ENTER_PROMPT, FIRST_ORDINAL, options.size());
    }

    @Override
    public void prompt() {
        System.out.println(listOptions(text, this.options));
    }

    @Override
    public void entryPrompt() {
        System.out.println(entryPrompt);
    }

    @Override
    public T parse(String input){
        int arg;
        try {
            arg = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
        if (arg < FIRST_ORDINAL || arg > this.maxOrdinal) {
            return null;
        }
        return options.get(arg - FIRST_ORDINAL);
    }

    private String listOptions(final String front, final List<T> options) {
        List<String> optionString = new ArrayList<>();
        optionString.add(front);
        for (int i = 0; i < options.size(); i++) {
            optionString.add(String.format("%d) %s", i + FIRST_ORDINAL, options.get(i)));
        }
        optionString.add(entryPrompt);
        return String.join("\n", optionString);
    }
}
