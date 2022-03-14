package edu.kit.informatik.model.Cards;

import java.util.Arrays;

/**
 * @author upkim
 * @version 1.0.0 2022-03-14
 */
public enum Dice {
    D4(4),
    D6(6),
    D8(8),
    D10(10),
    D12(12);

    private final int value;
    Dice(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int maxValue(){
        // TODO: 14.03.22 figure out functional
        //return Arrays.stream(Dice.values()).mapToInt(Dice::getValue).max().getAsInt();
        return 12;
    }
}
