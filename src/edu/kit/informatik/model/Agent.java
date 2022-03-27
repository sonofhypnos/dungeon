/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

package edu.kit.informatik.model;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.ui.OutputInterFace;
import java.util.List;

/**
 * The type Agent.
 *
 * @param <A> the type parameter
 * @param <T> the type parameter
 * @author upkim
 * @version 1.0.0 2022-03-27
 */
public abstract class Agent<A, T> {
    private static final int DEFAULT_PROTECTION = 0;
    private static final int MIN_HEALTH = 0;
    /**
     * The Abilities.
     */
    protected List<Ability<A, T>> abilities;
    /**
     * The Played ability.
     */
    protected Ability<A, T> playedAbility;
    /**
     * The Name.
     */
    protected String name;
    /**
     * The Max health.
     */
    protected int maxHealth;
    /**
     * The Health points.
     */
    protected int healthPoints;
    /**
     * The Focus points.
     */
    protected int focusPoints;
    /**
     * The New focus.
     */
    protected int newFocus;
    private final int minFocus;
    private boolean isDead = false;
    private Damage protection = new Damage();

    /**
     * Instantiates a new Agent.
     *
     * @param minFocus the min focus
     */
    protected Agent(int minFocus) {
        this.minFocus = minFocus;
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

    //    @Override
    //    public String toString() {
    //        return String.format("%s (%d/%d HP, %s FP)", getName(), getHealthPoints(), getMaxHealth(),
    //                getFocusPointStatus());
    //    }

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

        // TODO: 26.03.22 only add damage, if damage not 0.
        new OutputInterFace().printDamage(damage, this);
        // TODO: 17.03.22 how much damage if dies?
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
     * Eval focus int.
     *
     * @return the int
     */
    // TODO: 26.03.22 document sideeffect
    public int evalFocus() {
        final int output = newFocus;
        if (isFocusing()) {
            // TODO: 26.03.22 maybe do the io stuff somewhere else?
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

