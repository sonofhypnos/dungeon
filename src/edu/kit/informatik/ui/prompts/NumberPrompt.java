package edu.kit.informatik.ui.prompts;

import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class NumberPrompt implements Prompt<Integer> {

    public static final int FIRST_ORDINAL = 1;
    private static final String ENTER_NUMBER = "Enter number [%d--%d] separated by comma:";
    private int maxOrdinal;


    @Override
    public void prompt() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void entryPrompt() {
        throw new UnsupportedOperationException("");
    }

<<<<<<< HEAD
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
=======
    public Integer parse(String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }
>>>>>>> main

}
