package edu.kit.informatik.model.Cards;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.Archetype;
import edu.kit.informatik.model.abilities.player.PlayerAbilities;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class Player extends Agent<Player, List<Monster>> {

    private static final int INITIAL_HEALTH = 50;
    private static final Dice INITIAL_DICE = Dice.D4;
    private static final int INITIAL_FOCUS = 1;
    private static final int REFLECT_DAMAGE = 10;
    private List<Ability<Player, Monster>> cards; // TODO: 26.03.22 maybe make also card deck?
    private List<Ability<Player, Monster>> startingCards;
    private Dice dice;
    private boolean reflect;

    // TODO: 13.03.22 implement stuff for Fähigkeiten

    public Player(String name) {
        this.name = name;
        maxHealth = INITIAL_HEALTH;
        healthPoints = INITIAL_HEALTH;
        dice = INITIAL_DICE;
        focusPoints = INITIAL_FOCUS;
    }

    public void setClass(final Archetype gameArchetype) {
        // TODO: 13.03.22 make functions to set player abilities?


        // TODO: 14.03.22 make enum for this?
        switch (gameArchetype) {
            case MAGE:
                cards = new ArrayList<>(
                        List.of(PlayerAbilities.FOCUS.getAbility(), PlayerAbilities.WATER.getAbility()));
                break;
            case WARRIOR:
                cards = new ArrayList<>(
                        List.of(PlayerAbilities.THRUST.getAbility(), PlayerAbilities.PARRY.getAbility()));
                break;
            case PALADIN:
                cards = new ArrayList<>(
                        List.of(PlayerAbilities.SLASH.getAbility(), PlayerAbilities.REFLECT.getAbility()));
        }
        startingCards = cards;
    }

    public int getMaxFocusPoints() {
        return this.dice.getValue();
    }

    @Override
    public String getFocusPointStatus() {
        return String.format("%d/%d FP", focusPoints, getMaxFocusPoints());
    }


    public String getHealthStatus(){
        return String.format("%d/%d HP", healthPoints, INITIAL_HEALTH);
    }

    public void damage(final Damage damage, Monster aggressor) {
        if (isReflect() & damage.getType() == DamageType.MAGIC) {
            if (damage.getAmount() > REFLECT_DAMAGE) {
                damage.setAmount(damage.getAmount() - REFLECT_DAMAGE);
                checkDamage(damage);
                aggressor.damage(new Damage(damage.getType(), REFLECT_DAMAGE));
            } else {
                aggressor.damage(damage);
                return;
            }
        }
        checkDamage(damage); // this is to be applied after other effects
    }

    public List<Ability<Player, Monster>> getCards() {
        return new ArrayList<>(cards);
    }

    public void removeCard(Ability<Player, Monster> card) {
        this.cards.remove(card);
        // TODO: 25.03.22 there were some weird exceptions with cards maybe ask Johannes because I did not get it.
    }

    public void addCard(Ability<Player, Monster> card) {
        this.cards.add(card);
    }

    public Dice getDice() {
        return this.dice;
    }

    public void getNextDice() {
        assert !dice.isLast(); // TODO: 25.03.22 Needs to be checked above?
        this.dice = Dice.values()[dice.ordinal() + 1];
    }

    public List<Ability<Player, Monster>> getStartingCards() {
        return this.getCards().stream().filter((var card) -> this.startingCards.contains(card))
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

    public void heal(final int heal) {
        this.healthPoints += heal;
        if (this.healthPoints > this.getMaxHealth()) {
            this.healthPoints = this.getMaxHealth();
        }
    }

}
