package edu.kit.informatik.ui.prompts;

import edu.kit.informatik.ui.resources.Message;

import static java.lang.Integer.MAX_VALUE;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class SeedPrompt extends SelectNumbers {
    private static final int MAX_SEED = MAX_VALUE;
    private static final String ENTER_SEEDS = String.format("Enter seeds [%d--%d] separated by comma:", 1, MAX_SEED);

    public SeedPrompt(int seedNumber) {
        super(Message.SEEDS.toString(), ENTER_SEEDS, MAX_SEED, seedNumber);
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
