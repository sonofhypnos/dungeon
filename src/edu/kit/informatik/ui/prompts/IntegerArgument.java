package edu.kit.informatik.ui.prompts;

import edu.kit.informatik.ui.resources.ErrorMessage;

import java.text.ParseException;

import static edu.kit.informatik.ui.resources.ErrorMessage.ILLEGAL_FORMAT;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class IntegerArgument implements Argument<Integer> {
    private int minValue;
    private int maxValue;
    private int value;


    public IntegerArgument(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }


    @Override
    public Integer parse(final String str) {
        value = Integer.parseInt(str);
        if (value < minValue || value > maxValue) {
            System.err.println(ILLEGAL_FORMAT.toString()); // TODO: 10.03.22 make own stuff here
        }
        return value;
    }



}
