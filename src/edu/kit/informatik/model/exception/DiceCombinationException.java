/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

package edu.kit.informatik.model.exception;

/**
 * This exception should be thrown if a combination of dice contains to much tokens.  
 * 
 * @author Moritz Hertler
 * @version 1.0
 */
public class DiceCombinationException extends Exception {

    private static final long serialVersionUID = -2245855738200702287L;

    private final int numberOfTokens;
    private final int maxNumberOfTokens;

    /**
     * Constructs a new DiceCombinationException. 
     * 
     * @param numberOfTokens the illegal number of tokens in the dice combination
     * @param maxNumberOfTokens the maximum number of allowed tokens in a dice combination
     */
    public DiceCombinationException(int numberOfTokens, int maxNumberOfTokens) {
        this.numberOfTokens = numberOfTokens;
        this.maxNumberOfTokens = maxNumberOfTokens;
    }

    /**
     * Returns the illegal number of tokens in the dice combination.
     * 
     * @return the illegal number of tokens in the dice combination
     */
    public int getNumberOfTokens() {
        return this.numberOfTokens;
    }

    /**
     * The maximum number of allowed tokens in a dice combination
     * 
     * @return the maximum number of allowed tokens in a dice combination
     */
    public int getMaxNumberOfTokens() {
        return this.maxNumberOfTokens;
    }


}
