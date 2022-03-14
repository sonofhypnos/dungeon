package edu.kit.informatik.ui.prompts;

import edu.kit.informatik.ui.resources.Constants;
import edu.kit.informatik.ui.resources.Message;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Integer.MAX_VALUE;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class NumberPrompt extends SelectPrompt<Integer> {

    private static final String ENTER_NUMBER = "Enter number [%d--%d]";

    public NumberPrompt(String text, int maxOrdinal) {
        super(text, IntStream.range(1, maxOrdinal).boxed().collect(Collectors.toList()), ENTER_NUMBER);
    }

    @Override
    public void prompt() {
        System.out.println(Message.SEEDS);
        entryPrompt();
    }

    @Override
    public void entryPrompt() {
        System.out.println(String.format(this.entryPrompt, Constants.MIN_ORDINAL.getValue(), MAX_VALUE));
    }

//    public List<Integer> parse(String input) {
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
