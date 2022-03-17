package edu.kit.informatik.ui.prompts;

import edu.kit.informatik.ui.resources.Constants;
import edu.kit.informatik.ui.resources.Message;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.MAX_VALUE;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class NumberPrompt extends SelectPrompt<Integer> {

    private static final String ENTER_NUMBER = "Enter number [%d--%d]";

    public NumberPrompt(String text, String entryPrompt, int maxOrdinal) {
        super(text, entryPrompt, maxOrdinal);
    }

    @Override
    public void prompt() {
        System.out.println(text);
        entryPrompt();
    }

    @Override
    public void entryPrompt() {
        System.out.println(String.format(this.entryPrompt, Constants.MIN_ORDINAL.getValue(), MAX_VALUE));
    }

    @Override
    public Integer parseItem() {
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
        return arg;
    }

    //    public List<Integer> parseList(String input) {
//        List<Integer> args;
//        try {
//            args = Arrays.stream(input.split(SEP_REGEX, -1)) //undo terrible split defaults
//                    .map(Integer::parseUnsignedInt).collect(Collectors.toList());
//        } catch (NumberFormatException e) {
//            return null;
//        }
//        return args;
//    }

}
