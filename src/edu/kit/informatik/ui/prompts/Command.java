/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

package edu.kit.informatik.ui.prompts;

import java.util.List;

import edu.kit.informatik.ui.resources.ErrorMessage;

/**
 * This class represents a command that is executed by a {@link Session}.
 *
 * @author Moritz Hertler
 * @version 1.0
 */
public abstract class Command {

    /**
     * Applies the specified arguments to this command and runs the command.
     *
     * @param arguments the arguments given to this command
     */
    public void apply(List<String> arguments) {

        int numberOfArgs = arguments.size();
        int numberOfParams = this.getNumberOfParameters();

        if (numberOfArgs != numberOfParams) {
            System.err.println(ErrorMessage.ILLEGAL_ARGUMENT_COUNT.format(numberOfParams, numberOfArgs));
            return;
        }

        this.execute(arguments);
    }

    /**
     * Returns a regular expression of the command name.
     * The regex should not include any parameters or any whitespace.
     *
     * @return a regular expression of the command name
     */
    public abstract String getRegex();

    /**
     * The number of parameters this command specifies.
     *
     * @return the number of parameters this command specifies
     */
    public abstract int getNumberOfParameters();

    /**
     * The execute hook all commands have to implement.
     *
     * This method is only called if the number of arguments match the number of specified parameters.
     *
     * @param arguments the arguments given to this command
     */
    protected abstract void execute(List<String> arguments);
}
