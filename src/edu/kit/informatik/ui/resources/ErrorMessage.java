/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

package edu.kit.informatik.ui.resources;

/**
 * All error messages that are shown to the user.
 *
 * @author Moritz Hertler
 * @version 1.0
 */
public enum ErrorMessage {

    /**
     * The error message printed if a player enters an blank string as command.
     */
    EMPTY_COMMAND("please enter a command."),

    /**
     * The error message printed if the command was not found.
     *
     * Expects one format argument:
     * The command name entered by the user (string).
     */
    COMMAND_NOT_FOUND("there is no command called '%s'."),

    /**
     * The error message printed if a player entered values that could not be parsed
     */
    ILLEGAL_FORMAT("the input could not be parsed."),

    /**
     * The error message printed if the command did not have the expected number of arguments.
     *
     * Expects two format arguments in the following order:
     * The number of expected arguments (integer) and
     * the number of provided arguments (integer).
     */
    ILLEGAL_ARGUMENT_COUNT("expected %d argument(s) but got %d."),

    /**
     * The error message printed if an illegal player name was entered.
     *
     * Expects one format argument:
     * The illegal player name (string).
     */
    ILLEGAL_NAME("'%s' is not a legal name. Must be not empty and contain no whitespace."),

    /**
     * The error message printed if an illegal health count was entered.
     *
     * Expects one format argument:
     * The illegal health count (integer).
     */
    ILLEGAL_HEALTH("%d is not a legal initial health count."),

    /**
     * The error message printed if an illegal token count was entered.
     *
     * Expects one format argument:
     * The illegal token count (integer).
     */
    ILLEGAL_TOKEN_COUNT("%d is not a legal initial token count."),


    /**
     * The error message printed if a string could not be parsed to an integer.
     *
     * Expects one format argument:
     * The illegal string.
     */
    ILLEGAL_INTEGER("cannot parse %s into an integer."),

    /**
     * The error message printed if a string could not be parsed to a die.
     *
     * Expects one format argument:
     * The illegal string.
     */
    ILLEGAL_DIE("cannot parse %s into a die."),

    /**
     * The error message printed if rolled dice yield to much tokens.
     *
     * Expects two format arguments int the following order:
     * The maximum number of tokens (integer) and
     * the illegal number of tokens (integer).
     */
    ILLEGAL_ROLL_TOKEN_COUNT("a maximum of %d dice are allowed to yield tokens, but got %d."),

    /**
     * The error message printed if a string could not be parsed to a god favor.
     *
     * Expects one format argument:
     * The illegal string.
     */
    ILLEGAL_GOD_FAVOR("cannot parse %s into a god favor."),

    /**
     * The error message printed if a integer is not a legal god favor level.
     *
     * Expects three format arguments int the following order:
     * The illegal god favor level (integer),
     * the lowest possible level (integer) and
     * the highest possible level (integer).
     */
    ILLEGAL_GOD_FAVOR_LEVEL("cannot parse %d into a god favor level. Expected an integer between %d and %d."),

    /**
     * The error message printed if the executed command cannot be executed in the current game state.
     */
    ILLEGAL_GAME_STATE("cannot execute this command in the current game state.");

    private static final String PREFIX = "Error, ";

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    /**
     * Formats this message with the specified arguments.
     *
     * Calls {@link String#format(String, Object...)} internally.
     *
     * @param args arguments referenced by the format specifiers in the format string
     * @return the formatted string
     */
    public String format(Object... args) {
        return PREFIX + String.format(this.message, args);
    }

    @Override
    public String toString() {
        return PREFIX + this.message;
    }
}
