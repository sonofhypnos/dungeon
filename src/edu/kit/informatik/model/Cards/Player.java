package edu.kit.informatik.model.Cards;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.Archetype;
import edu.kit.informatik.model.abilities.player.PlayerAbilities;
import edu.kit.informatik.ui.prompts.DiceRoll;
import edu.kit.informatik.ui.prompts.Prompt;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class Player extends Agent<Player, List<Monster>> {

    private static final int MAX_FOCUS_POINTS = 5;
    private static final int INITIAL_HEALTH = 50;
    private static final Dice INITIAL_DICE = Dice.D4;
    private static final int REFLECT_DAMAGE = 10;
    private Archetype archetype;
    private List<Ability<Player, List<Monster>>> cards;
    private List<Ability<Player, List<Monster>>> startingCards;
    private Dice dice;
    private int roll;
    private boolean reflect;

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
//                cards = List.of(PlayerAbilities.FOCUS.getAbility(), PlayerAbilities.WATER.getAbility());
                break;
            case WARRIOR:
                cards = List.of(PlayerAbilities.THRUST.getAbility(), PlayerAbilities.PARRY.getAbility());
                break;
            case PALADIN:
//                cards = List.of(PlayerAbilities.SLASH.getAbility(), PlayerAbilities.REFLECT.getAbility());
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

    public void damage(final Damage damage, Monster aggressor) {
        if (isReflect()) {
            if (damage.getAmount() > REFLECT_DAMAGE) {
                damage.setAmount(damage.getAmount() - REFLECT_DAMAGE);
                aggressor.damage(new Damage(damage.getType(), REFLECT_DAMAGE));
            } else {
                aggressor.damage(damage);
                return;
            }
        }
        checkDamage(damage); // this is to be applied after other effects
    }

    public List<Ability<Player, List<Monster>>> getCards() {
        return new ArrayList<>(cards);
    }

    public Dice getDice() {
        return this.dice;
    }

    public void getNextDice() {
        assert !dice.isLast();
        this.dice = Dice.values()[dice.ordinal() + 1];
    }

    public void roll() {
        Prompt<Integer> dicePrompt = new DiceRoll(dice);
        this.roll = dicePrompt.parseItem();
    }

    public int getRoll() {
        return roll;
    }

    public List<Ability<Player, List<Monster>>> getStartingCards() {
        return this.getCards().stream().filter((Ability<Player, List<Monster>> card) -> this.startingCards.contains(card))
                .collect(Collectors.toList());
    }

    public boolean isReflect() {
        return reflect;
    }

    public void setReflect(final boolean reflect) {
        this.reflect = reflect;
    }

    @Override
    public void reset() {
        super.reset();
        this.setReflect(false);
    }
}
