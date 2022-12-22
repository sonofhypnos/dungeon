package edu.kit.informatik.model;

import edu.kit.informatik.ui.Terminal;

/**
 * Agent is the class with common functionality between monsters and player.
 *
 * @author upkim
 * @version 1.0.0 2022-03-27
 */
public abstract class Agent {
    private static final int DEFAULT_PROTECTION = 0;
    private static final int MIN_HEALTH = 0;
    private final int minFocus;
    private final String name;
    private final int maxHealth;
    private int healthPoints;
    private int focusPoints;
    private int newFocus;
    private boolean isDead = false;
    private Damage protection = new Damage();

    /**
     * Instantiates a new Agent.
     *
     * @param name          the name
     * @param minFocus      the min focus
     * @param initialFocus  the initial focus
     * @param initialHealth the initial health
     * @param maxHealth     the max health
     */
    protected Agent(final String name, int minFocus, final int initialFocus, final int initialHealth,
                    final int maxHealth) {
        this.name = name;
        this.minFocus = minFocus;
        this.maxHealth = maxHealth;
        this.focusPoints = initialFocus;
        this.healthPoints = initialHealth;
    }

    /**
     * Gets new focus.
     *
     * @return the new focus
     */
    protected int getNewFocus() {
        return newFocus;
    }

    /**
     * Sets new focus.
     *
     * @param newFocus the new focus
     */
    protected void setNewFocus(final int newFocus) {
        this.newFocus = newFocus;
    }

    /**
     * Gets max health.
     *
     * @return the max health
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets health points.
     *
     * @return the health points
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    /**
     * Sets health points.
     *
     * @param healthPoints the health points
     */
    protected void setHealthPoints(final int healthPoints) {
        this.healthPoints = healthPoints;
    }

    /**
     * Gets focus points.
     *
     * @return the focus points
     */
    public int getFocusPoints() {
        return focusPoints;
    }

    /**
     * Gets focus point status.
     *
     * @return the focus point status
     */
    public abstract String getFocusPointStatus();

    /**
     * Gets health status.
     *
     * @return the health status
     */
    public abstract String getHealthStatus();

    /**
     * Check damage.
     *
     * @param damage the damage
     */
    protected void checkDamage(final Damage damage) {
        if (protection.getType().equals(damage.getType())) {
            damage.setAmount(damage.getAmount() - protection.getAmount());
        }
        if (healthPoints > damage.getAmount()) {
            healthPoints -= damage.getAmount();
        } else {
            healthPoints = MIN_HEALTH;
            isDead = true;
        }

        Terminal.printDamage(damage, this);
    }

    /**
     * Is dead boolean.
     *
     * @return the boolean
     */
    public boolean isDead() {
        return isDead;
    }

    /**
     * Is focusing boolean.
     *
     * @return the boolean
     */
    public boolean isFocusing() {
        return newFocus != 0;
    }

    /**
     * Adds focusPoints to agent if focus was not broken and resets newFocus.
     *
     * @return the int
     */
    public int evalFocus() {
        final int output = newFocus;
        if (isFocusing()) {
            focusPoints += newFocus;
            resetFocus();
        }
        return output;
    }

    /**
     * Focus.
     *
     * @param focusPoints the focus points
     */
    public void focus(int focusPoints) {
        newFocus = focusPoints;
    }

    /**
     * Reset focus.
     */
    public void resetFocus() {
        this.newFocus = 0;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    /**
     * Sets protection.
     *
     * @param protection the protection
     */
    public void setProtection(final Damage protection) {
        this.protection = protection;
    }

    /**
     * Reset protection.
     */
    public void resetProtection() {
        if (this.protection != null) {
            this.protection.setAmount(DEFAULT_PROTECTION);
        }
    }

    /**
     * Reset.
     */
    public void reset() {
        resetProtection();
    }

    /**
     * Reduce focus.
     *
     * @param focusPointReduction the focus point reduction
     */
    public void reduceFocus(final int focusPointReduction) {
        final int newFocusPoints = focusPoints - focusPointReduction;
        this.focusPoints = Math.max(newFocusPoints, minFocus);
    }
}

