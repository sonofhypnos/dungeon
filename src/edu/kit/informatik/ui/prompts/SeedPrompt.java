package edu.kit.informatik.ui.prompts;

import edu.kit.informatik.model.exception.ParseException;
import edu.kit.informatik.ui.resources.Constants;
import edu.kit.informatik.ui.resources.ErrorMessage;
import edu.kit.informatik.ui.resources.Message;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.MAX_VALUE;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class SeedPrompt implements Prompt<Integer> {
    private static final String ENTER_SEEDS = "Enter seeds [%d--%d] separated by comma:";
    private static final String SEP_REGEX = ",";

    @Override
    public void prompt() {
        System.out.println(Message.SEEDS);
        entryPrompt();
    }

    @Override
    public void entryPrompt() {
        System.out.println(String.format(ENTER_SEEDS, Constants.MIN_ORDINAL.getValue(), MAX_VALUE));
    }

    public List<Integer> parse(String input) {
        List<Integer> args;
        try {
            args = Arrays.stream(input.split(SEP_REGEX, -1)) //undo terrible split defaults
                    .map(Integer::parseUnsignedInt).collect(Collectors.toList());
        } catch (NumberFormatException e) {
            return null;
        }
        return args;
    }



}
