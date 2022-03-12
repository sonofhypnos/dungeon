/*
 * Copyright (c) 2022, KASTEL. All rights reserved.
 */

package edu.kit.informatik.model;

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

    protected String getFocusPointStatus() {
        return focusPoints + "";
    }

    public <A extends Agent> String toString(A agent) {
        return String.format("%s (%d/%d HP, %s FP)", getName(), getHealthPoints(), getMaxHealth(),
                getFocusPointStatus());
    }
}
