package edu.kit.informatik.ui.prompts;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class SelectNumbers extends NumberPrompt {

    private static final String ENTER_NUMBERS = "Enter numbers [%d--%d] separated by comma:";
    private static final String SEPARATOR_REGEX = ",";
    private final String separator;
    private final int optionNumber;

    /**
     * Instantiates a new Select prompt.
     *
     * @param prePrompt    the prePrompt
     */
    public SelectNumbers(final String prePrompt, int maxOrdinal, int optionNumber) {
        super(prePrompt, ENTER_NUMBERS, maxOrdinal);
        this.separator = SEPARATOR_REGEX;
        this.optionNumber = optionNumber;
    }


    public SelectNumbers(final String text, final String entryPrompt, final int maxOrdinal, int optionNumber) {
        super(text, entryPrompt, maxOrdinal);
        this.separator = SEPARATOR_REGEX;
        this.optionNumber = optionNumber;
        // TODO: 17.03.22 add minimum input: (make it possible to enter nothing and make the game accept)
    }

    @Override
    public List<Integer> parseList() {

        List<Integer> args;
        Scanner scanner = ScannerSingleton.getInstance();
        while (true) {
            entryPrompt();
            String input = scanner.nextLine();
            if (input == null) {
                System.out.println("should not happen?");
            }
            try {
                args = Arrays.stream(Objects.requireNonNull(input).split(separator, -1)).map(Integer::parseUnsignedInt)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                continue;
            }
            if (args.size() != optionNumber || args.stream().anyMatch(i -> i < FIRST_ORDINAL || i > this.maxOrdinal))
                continue;
            break;
        }
        return args;
    }
}
