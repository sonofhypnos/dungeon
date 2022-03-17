package edu.kit.informatik.ui.prompts;

import edu.kit.informatik.model.Cards.Dice;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class DiceRoll extends NumberPrompt{

    private static final String DICE_PROMPT = ""; // make sure DiceRoll throws
    private static final String DICE_ENTRY_PROMPT = "Enter dice roll [%d--%d]:";

    public DiceRoll(final Dice dice) {
        super(DICE_PROMPT, DICE_ENTRY_PROMPT,  dice.getValue());
    }
    // TODO: 14.03.22 make sure throws exception if prompt() is used?
    // TODO: 14.03.22 maybe separate prompt and other stuff?
}
