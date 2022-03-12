/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

package edu.kit.informatik.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import edu.kit.informatik.model.Runa;
import edu.kit.informatik.ui.prompts.Command;

/**
 * This class describes a session for interactive command execution.
 * <p>
 * It executes {@link Command commands} that are provided via the {@link #addCommand(Command)} method.
 *
 * @author Moritz Hertler
 * @version 1.0
 */
public class Session {

    /**
     * The separator used to split the input string into command and argument string.
     */
    private static final String COMMAND_SEPARATOR = " ";
    /**
     * The separator used to split the argument string into separate arguments.
     */
    private static final String ARGUMENT_SEPARATOR = ";";
    public static final String QUIT = "quit";

    private final Scanner scanner;
    private final List<Command> commands;
    private final Runa game;
    private boolean running;

    /**
     * Constructs a new session.
     * @param game
     */
    public Session(final Runa game) {
        this.scanner = new Scanner(System.in);
        this.commands = new ArrayList<>();
        this.game = game;
        this.game.prompt();
    }

    /**
     * Starts the interactive command session.
     * Commands are read line by line from {@link System.in}.
     * If the input is {@code null} the interaction is exited.
     */
    public void start() {
        this.running = true;
        while (this.running) {
            String input = this.scanner.nextLine();
            if (input == null) {
                return;
            }
            processInput(input);
        }
    }

    /**
     * Processes a single line of input.
     *
     * @param input the line of input
     */
    private void processInput(String input) {
        if (input.equals(QUIT)) {
            this.stop();
        }

        this.game.run(input);

    }

    /**
     * Returns the command that matches the specified command name or {@link Optional#empty()}.
     *
     * @param commandName the command name
     * @return the command or {@link Optional#empty()}
     */
    private Optional<Command> findCommand(String commandName) {
        for (Command command : this.commands) {
            if (commandName.matches(command.getRegex())) {
                return Optional.of(command);
            }
        }
        return Optional.empty();
    }

    /**
     * Adds a new command to this session.
     *
     * @param command the command to be added
     */
    public void addCommand(Command command) {
        this.commands.add(command);
    }

    /**
     * Removes a command from this session.
     *
     * @param command the command to be removed
     * @return {@code true} if this session contained the specified command
     */
    public boolean removeCommand(Command command) {
        return this.commands.remove(command);
    }

    /**
     * Stops the interactive session.
     */
    public void stop() {
        this.running = false;
    }
}
