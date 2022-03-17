package edu.kit.informatik.ui.prompts;

import edu.kit.informatik.model.exception.ParseException;
import edu.kit.informatik.ui.resources.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    protected final String text;
    protected final String entryPrompt;

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

    /**
     * Instantiates a new Select prompt.
     *
     * @param text    the text
     * @param options the options
     */
    public SelectPrompt(String text, String entryPrompt, int maxOrdinal) {
        // TODO: 15.03.22 make abstract class so this does not have to be overwritten?
        this.text = text;
        this.options = null;
        this.maxOrdinal = maxOrdinal;
        this.entryPrompt = String.format(entryPrompt, FIRST_ORDINAL, maxOrdinal);
    }

    /**
     * Instantiates a new Select prompt.
     *
     * @param text        the text
     * @param options     the options
     * @param enterPrompt the enter prompt
     */
    public SelectPrompt(String text, List<T> options, String enterPrompt) {
        this.text = text;
        this.options = options;
        this.maxOrdinal = options.size() + FIRST_ORDINAL;
        this.entryPrompt = String.format(enterPrompt, FIRST_ORDINAL, options.size());
    }

    @Override
    public void prompt() {
        if (this.options.size() == 0) {
          return;
        }
        System.out.println(listOptions(text, this.options));
    }

    @Override
    public void entryPrompt() {
        System.out.println(entryPrompt);
    }

    @Override
    public List<T> parseList() {
        return List.of(parseItem());
    }

    @Override
    public T parseItem(){
        // TODO: 15.03.22 document we don't let user choose if 1 option

        if (options.size() == 1) return options.get(0);
        // TODO: 15.03.22 add while running
        prompt();
        Scanner scanner = ScannerSingleton.getInstance();
        int arg;
        while (true) {
            String input = scanner.nextLine();
            if (input == null) {
                System.out.println("should not happen?");
            }
            try {
                arg = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                entryPrompt();
                continue;
            }

            if (arg < FIRST_ORDINAL || arg > this.maxOrdinal) {
                continue;
            }
            break;
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
