/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

package edu.kit.informatik.model;

import edu.kit.informatik.model.Cards.Damage;
import edu.kit.informatik.model.Cards.abilities.Ability;

import java.util.List;

/**
 * The type Agent.
 */
public abstract class Agent {
    protected List<Ability> abilities;
    protected Ability playedAbility;
    protected String name;
    protected int maxHealth;
    protected int healthPoints;
    protected int focusPoints;
    protected boolean focusing = false;
    private boolean isDead = false;

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

    public Ability getPlayedAbility() {
        return playedAbility;
    }

    public abstract String getFocusPointStatus();

    public abstract String getHealthStatus();

    public <A extends Agent> String toString(A agent) {
        return String.format("%s (%d/%d HP, %s FP)", getName(), getHealthPoints(), getMaxHealth(),
                getFocusPointStatus());
    }

    public abstract void damage(Damage damage);

    protected void checkDamage(final Damage damage) {
        if (healthPoints > damage.getAmount()) {
            healthPoints -= damage.getAmount();
        } else {
            healthPoints = 0;
            isDead = true;
        }
    }

    public boolean isDead() {
        return isDead;
    }

    public boolean isFocusing() {
        return focusing;
    }

    public void setFocusing(final boolean focusing) {
        this.focusing = focusing;
    }
}
