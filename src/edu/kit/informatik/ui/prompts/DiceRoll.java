package edu.kit.informatik.ui.prompts;

import edu.kit.informatik.model.Cards.Dice;

/**
 * The type Dice roll.
 *
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class DiceRoll extends SelectPrompt<Integer> {

    private static final String DICE_PROMPT = ""; // make sure DiceRoll throws
    private static final String DICE_ENTRY_PROMPT = "Enter dice roll [%d--%d]:";

    /**
     * Instantiates a new Dice roll.
     *
     * @param dice the dice
     */
    public DiceRoll(final Dice dice) {
        super(DICE_PROMPT, DICE_ENTRY_PROMPT, dice.getValue(), true);
    }


    @Override
    public void prompt() {
    }

    @Override
    public Integer parseItem() {
        return getInt();
    }
}
