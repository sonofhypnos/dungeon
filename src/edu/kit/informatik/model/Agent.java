/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

package edu.kit.informatik.model;

import edu.kit.informatik.model.abilities.Ability;

import edu.kit.informatik.ui.OutputInterFace;
import java.util.List;

/**
 * The type Agent.
 */
public abstract class Agent<A, T> {
    private static final int DEFAULT_PROTECTION = 0;
    private static final int MIN_HEALTH = 0;
    protected List<Ability<A, T>> abilities;
    protected Ability<A, T> playedAbility;
    protected String name;
    protected int maxHealth;
    protected int healthPoints;
    protected int focusPoints;
    protected int newFocus;
    private final int minFocus;
    private boolean isDead = false;
    private Damage protection = new Damage();

    protected Agent(int minFocus) {
        this.minFocus = minFocus;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getFocusPoints() {
        return focusPoints;
    }

    public Ability<?,?> getPlayedAbility() {
        return playedAbility;
    }

    public abstract String getFocusPointStatus();

    public abstract String getHealthStatus();

//    @Override
//    public String toString() {
//        return String.format("%s (%d/%d HP, %s FP)", getName(), getHealthPoints(), getMaxHealth(),
//                getFocusPointStatus());
//    }

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

    public boolean isDead() {
        return isDead;
    }

    public boolean isFocusing() {
        return newFocus != 0;
    }

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

    public void focus(int focusPoints){
        newFocus = focusPoints;
    }

    public void resetFocus() {
        this.newFocus = 0;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public void setProtection(final Damage protection){
        this.protection = protection;
    }

    public void resetProtection() {
        if (this.protection != null) {
            this.protection.setAmount(DEFAULT_PROTECTION);
        }
    }

    public void reset(){
        resetProtection();
    }

    public void reduceFocus(final int focusPointReduction) {
        final int newFocusPoints = focusPoints - focusPointReduction;
        this.focusPoints = Math.max(newFocusPoints, minFocus);
    }
}

