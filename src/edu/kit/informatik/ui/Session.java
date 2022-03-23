/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

package edu.kit.informatik.ui;

import java.util.Scanner;

import edu.kit.informatik.model.GameContext;

/**
 * This class describes a session for interactive command execution.
 * <p>
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
    private final GameContext game;
    private boolean running;

    /**
     * Constructs a new session.
     * @param game
     */
    public Session(final GameContext game) {
        this.scanner = new Scanner(System.in);
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
     * Stops the interactive session.
     */
    public void stop() {
        this.running = false;
    }
}
