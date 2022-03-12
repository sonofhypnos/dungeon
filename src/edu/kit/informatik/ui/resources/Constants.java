package edu.kit.informatik.ui.resources;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public enum Constants {
    MIN_ORDINAL(1);

    private final int value;

    Constants(final int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
