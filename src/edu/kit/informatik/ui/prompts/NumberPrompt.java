package edu.kit.informatik.ui.prompts;

import java.util.Scanner;

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
    }

    @Override
    public void entryPrompt() {
        System.out.printf((this.entryPrompt) + "%n", FIRST_ORDINAL, MAX_VALUE);
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
