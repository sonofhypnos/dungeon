package edu.kit.informatik.model.Cards;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Cards.abilities.Ability;
import edu.kit.informatik.model.Cards.abilities.Effect;
import edu.kit.informatik.model.Archetype;
import edu.kit.informatik.model.Cards.abilities.Focus;
import edu.kit.informatik.model.Cards.abilities.Parry;
import edu.kit.informatik.model.Cards.abilities.Reflect;
import edu.kit.informatik.model.Cards.abilities.Slash;
import edu.kit.informatik.model.Cards.abilities.Thrust;
import edu.kit.informatik.model.Cards.abilities.Water;
import java.util.ArrayList;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class Player extends Agent {

    private static final int MAX_FOCUS_POINTS = 5;
    private static final int INITIAL_HEALTH = 50;
    private static final Dice INITIAL_DICE = Dice.D4;
    private Archetype archetype;
    private List<Ability> cards;
    private List<Ability> startingCards;
    private Dice dice;

    // TODO: 13.03.22 implement stuff for Fähigkeiten

    public Player(String name) {
        this.name = name;
        healthPoints = INITIAL_HEALTH;
        focusPoints = MAX_FOCUS_POINTS;
        dice = INITIAL_DICE;
    }

    /**
     * Constructs a new player.
     *
     * @param name              the name
     * @param initialHealth     the initial health points
     * @param focusPoints the initial focus points
     */
    public Player(final String name, final int initialHealth, final int focusPoints) {
        this.name = name;
        // TODO: 13.03.22 remove this constructor?
        this.healthPoints = initialHealth;
        this.focusPoints = focusPoints;
    }

    public void setClass(final Archetype gameArchetype) {
        this.archetype = gameArchetype;
        // TODO: 13.03.22 make functions to set player abilities?


        // TODO: 14.03.22 make enum for this?
        switch (archetype) {
            case MAGE:
                cards = List.of(new Focus(1), new Water(1));
                break;
            case WARRIOR:
                cards = List.of(new Thrust(1), new Parry(1));
                break;
            case PALADIN:
                cards = List.of(new Slash(1), new Reflect(1));
        }
        startingCards = cards;
    }

    public static int getMaxFocusPoints() {
        return MAX_FOCUS_POINTS;
    }

    @Override
    public String getFocusPointStatus() {
        return String.format("%d/%d", focusPoints, MAX_FOCUS_POINTS);
    }


    public String getHealthStatus(){
        return String.format("%d/%d", healthPoints, INITIAL_HEALTH);
    }

    @Override
    public void damage(final Damage damage) {
        checkDamage(damage);
    }

    public List<Ability> getCards() {
        return new ArrayList<>(cards);
    }

}
