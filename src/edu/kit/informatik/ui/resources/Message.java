/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

package edu.kit.informatik.ui.resources;

/**
 * All messages that are shown to the user and are not error messages.
 *
 * @author Moritz Hertler
 * @version 1.0
 */
public enum Message {

    /**
     * The message printed when a game command executed successfully.
     */
    OK("OK"),

    /**
     * The Introduction.
     */
    INTRODUCTION("Welcome to Runa’s Strive\n" + "Select Runa’s character class"),
    /**
     * The Seeds.
     */
    SEEDS("To shuffle ability cards and monsters, enter two seeds"),


    /**
     * The message printed by the print command.
     * <p>
     * Expects three format arguments in the following order:
     * The name of the player (string),
     * their current health points (integer) and
     * their current token count (integer).
     */
    PRINT_PLAYER("%s;%d;%d"),

    /**
     * The message printed if a player has won.
     * <p>
     * Expects one format argument:
     * The name of the player (string).
     */
    GAME_OVER_WIN("%s wins"),

    /**
     * The message printed if the game ends in a draw.
     */
    GAME_OVER_DRAW("draw");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    /**
     * Formats this message with the specified arguments.
     * <p>
     * Calls {@link String#format(String, Object...)} internally.
     *
     * @param args arguments referenced by the format specifiers in the format string
     * @return the formatted string
     */
    public String format(Object... args) {
        return String.format(this.message, args);
    }

    @Override
    public String toString() {
        return this.message;
    }
}
