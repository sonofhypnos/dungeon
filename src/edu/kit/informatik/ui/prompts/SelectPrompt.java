package edu.kit.informatik.ui.prompts;

import edu.kit.informatik.ui.ScannerSingleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

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
    private static final String ENTER_NUMBERS_D_D_SEPARATED_BY_COMMA = "Enter numbers [%d--%d] separated by comma:";
    private static final int SPLIT_LIMIT = -1;
    private static final String QUIT_REGEX = "quit";
    private static final int EXIT_STATUS = 0;
    protected final String text;
    protected final String entryPrompt;
    /**
     * The Options.
     */
    List<T> options;
    /**
     * The Max ordinal.
     */
    int maxOrdinal;
    private int minOptionNumber;
    private int maxOptionNumber;
    private String separator;

    /**
     * Instantiates a new Select prompt.
     *
     * @param text    the text
     * @param options the options
     */
    public SelectPrompt(String text, List<T> options) {
        this.text = text;
        this.options = options;
        this.maxOrdinal = options.size() + FIRST_ORDINAL; // TODO: 18.03.22 why here not same as below?
        this.entryPrompt = String.format(ENTER_PROMPT, FIRST_ORDINAL, options.size());
    }

    /**
     * Instantiates a new Select prompt.
     *
     * @param text the text
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
     * @param text    the text
     * @param options the options
     */
    public SelectPrompt(String text, List<T> options, int minOptionNumber, int maxOptionNumber) {
        this.text = text;
        this.options = options;
        this.maxOrdinal = options.size() + FIRST_ORDINAL - 1; // TODO: 18.03.22 this is confusing even me!
        this.minOptionNumber = minOptionNumber;
        this.maxOptionNumber = maxOptionNumber;
        this.separator = ",";
        this.entryPrompt = String.format(ENTER_NUMBERS_D_D_SEPARATED_BY_COMMA, FIRST_ORDINAL, options.size());
    }

    @Override
    public void prompt() {
        listOptions(text, this.options);
    }

    @Override
    public void entryPrompt() {
        System.out.println(entryPrompt);
    }

    @Override
    public List<T> parseList() {
        List<Integer> args = getIntegers(separator, this.minOptionNumber, this.maxOrdinal, maxOptionNumber);
        return args.stream().map((Integer x) -> options.get(x)).collect(Collectors.toList());
    }



    @Override
    public T parseItem() {
        // TODO: 15.03.22 document we don't let user choose if 1 option
        // TODO: 18.03.22 use getIntegers here against code duplication

        if (options.size() == 1) return options.get(0);
        // TODO: 15.03.22 add while running
        int arg = getInt(this.maxOrdinal);
        return options.get(arg - FIRST_ORDINAL);
        // TODO: 17.03.22 figure out what happens if you first enter wrong and then correct values
    }

    protected List<Integer> getIntegers(final String separator, final int maxOrdinal, final int minOptionNumber,
                                        final int maxOptionNumber) {

        List<Integer> args;
        Scanner scanner = ScannerSingleton.getInstance();
        while (true) {
            entryPrompt();
            String input = scanner.nextLine();
            quit(input);
            assert input != null;
            try {
                args = Arrays.stream(Objects.requireNonNull(input).split(separator, SPLIT_LIMIT)).map(Integer::parseUnsignedInt)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                continue;
            }
            if (args.size() < minOptionNumber || args.size() > maxOptionNumber || args.stream()
                    .anyMatch(i -> inIntervall(i, maxOrdinal))) continue;
            break;
        }
        return args;
    }

    private void quit(final String input) {
        if (QUIT_REGEX.equals(input)) {
            Runtime.getRuntime().exit(EXIT_STATUS);
        }
    }

    private boolean inIntervall(final Integer i, final int maxOrdinal) {
        return i < FIRST_ORDINAL || i > maxOrdinal;
    }


    protected int getInt(int maxOrdinal) {
        this.prompt();
        Scanner scanner = ScannerSingleton.getInstance();
        int arg;
        while (true) {
            entryPrompt();
            String input = scanner.nextLine();
            quit(input);
            assert input != null;
            try {
                arg = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                continue;
            }

            if (arg < FIRST_ORDINAL || arg > maxOrdinal) {
                continue;
            }
            break;
        }
        return arg;
    }
    // TODO: 18.03.22 throw exception if arguments

    private void listOptions(final String front, final List<T> options) {
        List<String> optionString = new ArrayList<>();
        System.out.println(front);
        for (int i = 0; i < options.size(); i++) {
            optionString.add(String.format("%d) %s", i + FIRST_ORDINAL, options.get(i)));
        }
        System.out.println(String.join("\n", optionString));
    }
}
