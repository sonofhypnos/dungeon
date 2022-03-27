package edu.kit.informatik.ui.prompts;

import static java.lang.Integer.MAX_VALUE;

/**
 * The type Seed prompt.
 *
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class SeedPrompt extends SelectNumbers {
    private static final int MAX_SEED = MAX_VALUE;
    private static final String SEEDS = "To shuffle ability cards and monsters, enter two seeds";
    private static final String ENTER_SEEDS = String.format("Enter seeds [%d--%d] separated by comma:", 1, MAX_SEED);
    private static final String SEPARATOR_REGEX = ",";

    /**
     * Instantiates a new Seed prompt.
     *
     * @param seedNumber the seed number
     */
    public SeedPrompt(int seedNumber) {
        super(SEEDS, ENTER_SEEDS, MAX_SEED, seedNumber, SEPARATOR_REGEX);
    }
}
