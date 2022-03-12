package edu.kit.informatik.model.Cards;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Class;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class Player extends Agent {

    private static final int MAX_FOCUS_POINTS = 5;
    private static final int INITIAL_HEALTH = 4;
    private Class gameClass;

    public Player(String name) {
        super(name, INITIAL_HEALTH, MAX_FOCUS_POINTS);
        focusPoints = MAX_FOCUS_POINTS;
    }

    /**
     * Constructs a new player.
     *
     * @param name              the name
     * @param initialHealth     the initial health points
     * @param focusPoints the initial focus points
     */
    public Player(final String name, final int initialHealth, final int focusPoints) {
        super(name, initialHealth, focusPoints);
    }

    public void setClass(final Class gameClass ) {
        this.gameClass= gameClass;
    }

    public static int getMaxFocusPoints() {
        return MAX_FOCUS_POINTS;
    }

    @Override
    protected String getFocusPointStatus() {
        return super.getFocusPointStatus();
    }
}
