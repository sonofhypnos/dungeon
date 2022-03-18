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
    protected List<Ability<A, T>> abilities;
    protected Ability<A, T> playedAbility;
    protected String name;
    protected int maxHealth;
    protected int healthPoints;
    protected int focusPoints;
    protected int newFocus = 0;
    private boolean isDead = false;
    private Damage protection;

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
        if (healthPoints > damage.getAmount()) {
            healthPoints -= damage.getAmount();
        } else {
            healthPoints = 0;
            isDead = true;
        }

        new OutputInterFace().printDamage(damage, this);
        // TODO: 17.03.22 how much damage if dies?
    }

    public boolean isDead() {
        return isDead;
    }

    public boolean isFocusing() {
        return newFocus != 0;
    }

    public void evalFocus() {
        if (isFocusing()) {
            focusPoints += newFocus;
            resetFocus();
        }
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

    public void setFocus(final int focusPoints) {
        this.focusPoints = focusPoints;
    }
}

