package edu.kit.informatik.ui.prompts;

import edu.kit.informatik.ui.OutputInterFace;
import edu.kit.informatik.ui.ScannerSingleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Main implementation of Prompt Interface.
 *
 * @param <T> the type parameter
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class SelectPrompt<T> implements Prompt<T> {

    private static final String ENTER_PROMPT = "Enter number [%d--%d]:";
    private static final String SEPARATED_BY_COMMA = "Enter numbers [%d--%d] separated by comma:";
    private static final int SPLIT_LIMIT = -1;
    private static final String QUIT = "quit";
    private static final int DEFAULT_OPTION_NUMBER = 1;
    private static final String OPTION_ITEM = "%d) %s";
    private static final String OPTION_DELIMITER = "\n";
    private static final String PLUS_SIGN = "+";
    private static final String EMPTY_STRING = "";
    private static final String DEFAULT_SEPARATOR = ",";

    private static boolean running = true;
    /**
     * The Text.
     */
    protected final String text;
    /**
     * The Entry prompt.
     */
    protected final String entryPrompt;
    /**
     * Interface for output
     */
    protected OutputInterFace interFace = new OutputInterFace();
    /**
     * Maximum Ordinal the User can input.
     */
    protected int maxOrdinal;
    /**
     * options for the User
     */
    List<T> options;
    private final int minOptionNumber;
    private final int maxOptionNumber;
    private String separator = DEFAULT_SEPARATOR;

    /**
     * Instantiates a new Select prompt.
     *
     * @param text    the text
     * @param options the options
     */
    public SelectPrompt(String text, List<T> options) {
        this.text = text;
        this.options = options;
        this.maxOrdinal = options.size(); // TODO: 18.03.22 why here not same as below?
        this.entryPrompt = String.format(ENTER_PROMPT, FIRST_ORDINAL, options.size());
        this.minOptionNumber = DEFAULT_OPTION_NUMBER;
        this.maxOptionNumber = DEFAULT_OPTION_NUMBER;
    }

    /**
     * Instantiates a new Select prompt.
     *
     * @param text        the text
     * @param entryPrompt the entry prompt
     * @param maxOrdinal  the max ordinal
     */
    public SelectPrompt(String text, String entryPrompt, int maxOrdinal) {
        // TODO: 15.03.22 make abstract class so this does not have to be overwritten?
        this.text = text;
        this.options = null;
        this.maxOrdinal = maxOrdinal;
        this.entryPrompt = String.format(entryPrompt, FIRST_ORDINAL, maxOrdinal);
        this.minOptionNumber = DEFAULT_OPTION_NUMBER;
        this.maxOptionNumber = DEFAULT_OPTION_NUMBER;
    }


    /**
     * Instantiates a new Select prompt.
     *
     * @param text            the text
     * @param options         the options
     * @param minOptionNumber the min option number
     * @param maxOptionNumber the max option number
     */
    public SelectPrompt(String text, List<T> options, int minOptionNumber, int maxOptionNumber) {
        this.text = text;
        this.options = options;
        this.maxOrdinal = options.size() + FIRST_ORDINAL - 1; // TODO: 18.03.22 this is confusing even me!
        this.minOptionNumber = minOptionNumber;
        this.maxOptionNumber = maxOptionNumber;
        this.separator = ",";
        if (maxOptionNumber == 1) {
            this.entryPrompt = String.format(ENTER_PROMPT, FIRST_ORDINAL, options.size());
            // TODO: 27.03.22 there is still something confusing about abilitycards!
        } else {
            this.entryPrompt = String.format(SEPARATED_BY_COMMA, FIRST_ORDINAL, options.size());
        }
    }


    private static void stopRunning() {
        SelectPrompt.running = false;
    }


    /**
     * This is done so quit can be called at any time. A check for running needs to be added after every call to
     * parseList or parseItem. We admit that having these if-checks is a bit ugly, but we felt that in this case this
     * was less convoluted (We can run the main game logic in one function and can use niceties like for loops) than
     * adding a gamestate class for every time we want to ask for input from the user (which also wouldn't have greatly
     * increased the separation). The only justfication for gamestates in this instance we found would have been that
     * the quit command would have been nicer to implement, but we accepted this tradoff. We felt having to create a new
     * state every time we want to ask for user-input would have been more annoying.
     *
     * @return running boolean
     */
    public static boolean isRunning() { // TODO: 25.03.22 figure out how to defend this?
        return SelectPrompt.running;
    }

    @Override
    public void prompt() {
        interFace.println(listOptions(text, this.options));
    }

    @Override
    public void entryPrompt() {
        if (!SelectPrompt.isRunning()) {
            return;
        }
        interFace.println(entryPrompt);
    }

    @Override
    public List<T> parseList() {
        if (!SelectPrompt.isRunning()) {
            return null;
        }
        List<Integer> args = getIntegers(separator, this.maxOrdinal, this.minOptionNumber, maxOptionNumber);
        if (!SelectPrompt.isRunning()) {
            return null;
        }
        return args.stream().map((Integer x) -> options.get(x - 1)).collect(Collectors.toList());
    }

    @Override
    public T parseItem() {
        // TODO: 15.03.22 document we don't let user choose if 1 option
        // TODO: 18.03.22 use getIntegers here against code duplication

        if (!SelectPrompt.isRunning()) {
            return null;
        }
        if (options.size() == 1) return options.get(0);
        // TODO: 15.03.22 add while running
        Integer arg = getInt();
        if (arg == null) return null;
        // TODO: 25.03.22 we get index out of bounds if 1 above correct value
        return options.get(arg - FIRST_ORDINAL);
        // TODO: 17.03.22 figure out what happens if you first enter wrong and then correct values

    }

    /**
     * Returns Integer the user put into prompt. Returns null on quit and sets Selectionprompt.running to false.
     *
     * @return the int
     */
    Integer getInt() {
        List<Integer> args = getIntegers(separator, maxOrdinal, minOptionNumber, maxOptionNumber);
        if (!SelectPrompt.isRunning()) {
            return null;
        }
        return args.get(0); //guaranteed to exist
        // TODO: 27.03.22 make sure this is only called when lenght supposed to be 0?
    }

    /**
     * Returns Integers the User put into prompt. Returns null on quit and sets Selectionprompt.running to false.
     *
     * @param separator       the separator
     * @param maxOrdinal      the max ordinal
     * @param minOptionNumber the min option number
     * @param maxOptionNumber the max option number
     * @return the integers
     */
    protected List<Integer> getIntegers(final String separator, final int maxOrdinal, final int minOptionNumber,
                                        final int maxOptionNumber) {
        this.prompt();
        // TODO: 23.03.22 hübsscher (mach weninger wenn nicht laufend)
        // TODO: 26.03.22 make all of this pretty (make einheitlich mit getInt (or refactor everything anyway?)
        List<Integer> args = null;
        // TODO: 26.03.22 if there is a newline inputted, then this is also null! maybe make more pretty?
        Scanner scanner = ScannerSingleton.getInstance();
        while (isRunning()) {
            entryPrompt();
            String input = scanner.nextLine();
            quit(input);
            if (!isRunning()) {
                return null;
            }
            assert input != null;
            final boolean noInteger = minOptionNumber == EMPTY_STRING.length() && input.equals(EMPTY_STRING);
            if (noInteger) { //check for 0 integers, since parseUnsignedInt would throw an exception otherwise.
                return List.of();
            }
            if (input.contains(PLUS_SIGN)) { //check for + since this might be parsed as valid input by parseInt
                continue;
            }
            try {
                args = Arrays.stream(Objects.requireNonNull(input).split(separator, SPLIT_LIMIT))
                        .map(Integer::parseUnsignedInt).collect(Collectors.toList());
            } catch (NumberFormatException e) {
                continue;
            }
            if (args.size() < minOptionNumber || args.size() > maxOptionNumber || args.stream()
                    .anyMatch(arg -> outSideInterval(arg, maxOrdinal))) continue;
            break;
        }
        return args;
    }

    private void quit(final String input) {
        // TODO: 26.03.22 there is all kinds of stuff that still gets printed on quit!
        if (QUIT.equals(input)) {
            SelectPrompt.stopRunning();
        }
    }

    private boolean outSideInterval(final Integer i, final int maxOrdinal) {
        return i < FIRST_ORDINAL || i > maxOrdinal;
    }

    private String listOptions(final String front, final List<T> options) {
        List<String> optionString = new ArrayList<>();
        for (int i = 0; i < options.size(); i++) {
            optionString.add(String.format(OPTION_ITEM, i + FIRST_ORDINAL, options.get(i)));
        }
        return front + OPTION_DELIMITER + String.join(OPTION_DELIMITER, optionString);
    }
}
