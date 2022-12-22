package informatik.ui.prompts;

import edu.kit.informatik.ui.ScannerSingleton;
import edu.kit.informatik.ui.Terminal;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Main implementation of Prompt interface and thus responsible for parsing user-input.
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
    private final String text;
    /**
     * The Entry prompt.
     */
    private final String entryPrompt;
    private final int minOptionNumber;
    private final int maxOptionNumber;

    /**
     * options for the User
     */
    private final List<T> options;
    /**
     * Maximum Ordinal the User can input.
     */
    private final int maxOrdinal;
    private String separator = DEFAULT_SEPARATOR;
    private boolean askSingle = false;
    private boolean noDuplicates = true;

    /**
     * Instantiates a new Select prompt.
     *
     * @param text    the text
     * @param options the options
     */
    public SelectPrompt(String text, List<T> options) {
        this.text = text;
        this.options = options;
        this.maxOrdinal = options.size();
        this.entryPrompt = String.format(ENTER_PROMPT, 1, options.size());
        this.minOptionNumber = DEFAULT_OPTION_NUMBER;
        this.maxOptionNumber = DEFAULT_OPTION_NUMBER;
    }

    /**
     * Instantiates a new Select prompt.
     *
     * @param text      the text
     * @param options   the options
     * @param askSingle the ask single
     */
    public SelectPrompt(String text, List<T> options, boolean askSingle) {
        this.text = text;
        this.options = options;
        this.maxOrdinal = options.size();
        this.entryPrompt = String.format(ENTER_PROMPT, 1, options.size());
        this.minOptionNumber = DEFAULT_OPTION_NUMBER;
        this.maxOptionNumber = DEFAULT_OPTION_NUMBER;
        this.askSingle = askSingle;
    }

    /**
     * SelectPrompt constructor for Prompt<Integer>
     *
     * @param text         the text
     * @param entryPrompt  the entry prompt
     * @param maxOrdinal   the max ordinal
     * @param noDuplicates whether to allow duplicates in the parsed integers
     */
    protected SelectPrompt(String text, String entryPrompt, int maxOrdinal, final boolean noDuplicates) {
        this.text = text;
        this.options = null;
        this.maxOrdinal = maxOrdinal;
        this.entryPrompt = String.format(entryPrompt, 1, maxOrdinal);
        this.minOptionNumber = DEFAULT_OPTION_NUMBER;
        this.maxOptionNumber = DEFAULT_OPTION_NUMBER;
        this.noDuplicates = noDuplicates;
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
        this.maxOrdinal = options.size();
        this.minOptionNumber = minOptionNumber;
        this.maxOptionNumber = maxOptionNumber;
        this.separator = DEFAULT_SEPARATOR;
        if (maxOptionNumber == 1) {
            this.entryPrompt = String.format(ENTER_PROMPT, 1, options.size());
        } else {
            this.entryPrompt = String.format(SEPARATED_BY_COMMA, 1, options.size());
        }
    }

    /**
     * Stops the Prompt from Running
     */
    public static void stopRunning() {
        SelectPrompt.running = false;
    }

    /**
     * The isRunning function and the running field is used, so quit can be called at any time. A check for running
     * needs to be added after every call to parseList or parseItem. We admit that having these if-checks is a bit ugly,
     * but we felt that in this case this was less convoluted (We can run the main game logic in one function and can
     * use niceties like for loops) than adding a game state class for every time we want to ask for input from the
     * user.
     * <p>
     * The only justification for game states in this instance we found would have been that the quit command would have
     * been easier to implement, but we accepted this tradeoff.
     *
     * @return running boolean
     */
    public static boolean isRunning() {
        return SelectPrompt.running;
    }

    /**
     * Gets text.
     *
     * @return the text
     */
    protected String getText() {
        return text;
    }

    /**
     * Gets entry prompt.
     *
     * @return the entry prompt
     */
    protected String getEntryPrompt() {
        return entryPrompt;
    }

    /**
     * Gets max ordinal.
     *
     * @return the max ordinal
     */
    protected int getMaxOrdinal() {
        return maxOrdinal;
    }

    @Override
    public void prompt() {
        Terminal.println(listOptions(text, this.options));
    }

    @Override
    public void entryPrompt() {
        if (!SelectPrompt.isRunning()) {
            return;
        }
        Terminal.println(entryPrompt);
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
        if (!SelectPrompt.isRunning()) {
            return null;
        }
        if (options.size() == 1 && !askSingle) return options.get(0);
        Integer arg = getInt();
        if (arg == null) return null;
        return options.get(arg - 1);
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
        List<Integer> args = null;
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
            final boolean containsDuplicate = args.stream().distinct().count() != args.size();
            if (containsDuplicate && noDuplicates)
                continue;
            if (args.size() < minOptionNumber || args.size() > maxOptionNumber || anyOutsideInterval(maxOrdinal, args))
                continue;
            break;
        }
        return args;
    }

    private boolean anyOutsideInterval(final int maxOrdinal, final List<Integer> args) {
        return args.stream().anyMatch(arg -> outSideInterval(arg, maxOrdinal));
    }

    private void quit(final String input) {
        if (QUIT.equals(input)) {
            SelectPrompt.stopRunning();
        }
    }

    private boolean outSideInterval(final Integer i, final int maxOrdinal) {
        return i < 1 || i > maxOrdinal;
    }

    private String listOptions(final String front, final List<T> options) {
        List<String> optionString = new ArrayList<>();
        for (int i = 0; i < options.size(); i++) {
            optionString.add(String.format(OPTION_ITEM, i + 1, options.get(i)));
        }
        return front + OPTION_DELIMITER + String.join(OPTION_DELIMITER, optionString);
    }
}
