package edu.kit.informatik.model.Cards;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Archetype;
import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.player.PlayerAbilities;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Player.
 *
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class Player extends Agent<Player, List<Monster>> {

    private static final int INITIAL_HEALTH = 50;
    private static final Dice INITIAL_DICE = Dice.D4;
    private static final int REFLECT_DAMAGE = 10;
    private static final int MIN_FOCUS = 1;
    private final List<Ability<Player, Monster>> hand = new ArrayList<>(); // TODO: 26.03.22 maybe make also card deck?
    private List<PlayerAbilities> startingCards;
    private Dice dice;
    private boolean reflect;
    /**
     * Instantiates a new Player.
     *
     * @param name the name
     */
    public Player(String name) {
        // TODO: 26.03.22 add other stuff in constructor
        super(MIN_FOCUS);
        this.name = name;
        maxHealth = INITIAL_HEALTH;
        healthPoints = INITIAL_HEALTH;
        dice = INITIAL_DICE;
        focusPoints = MIN_FOCUS;
    }

    // TODO: 13.03.22 implement stuff for Fähigkeiten

    public List<PlayerAbilities> getStartingCards() {
        return new ArrayList<>(startingCards);
    }

    /**
     * Sets class.
     *
     * @param gameArchetype the game archetype
     */
    public void setClass(final Archetype gameArchetype) {
        // TODO: 13.03.22 make functions to set player abilities?


        // TODO: 14.03.22 make enum for this?
        switch (gameArchetype) {
            case MAGE:
                startingCards = new ArrayList<>(List.of(PlayerAbilities.FOCUS, PlayerAbilities.WATER));
                break;
            case WARRIOR:
                startingCards = new ArrayList<>(List.of(PlayerAbilities.THRUST, PlayerAbilities.PARRY));
                break;
            case PALADIN:
                startingCards = new ArrayList<>(List.of(PlayerAbilities.SLASH, PlayerAbilities.REFLECT));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + gameArchetype); // TODO: 27.03.22 is this
        }
        this.hand.addAll(startingCards.stream().map(PlayerAbilities::getAbility).collect(Collectors.toList()));
    }

    /**
     * Gets max focus points.
     *
     * @return the max focus points
     */
    public int getMaxFocusPoints() {
        return this.dice.getValue();
    }

    @Override
    public String getFocusPointStatus() {
        return String.format("%d/%d FP", focusPoints, getMaxFocusPoints());
    }


    public String getHealthStatus() {
        return String.format("%d/%d HP", healthPoints, INITIAL_HEALTH);
    }

    /**
     * Damage.
     *
     * @param damage    the damage
     * @param aggressor the aggressor
     */
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

    /**
     * Gets cards.
     *
     * @return the cards
     */
    public List<Ability<Player, Monster>> getHand() {
        return new ArrayList<>(hand);
    }

    /**
     * Remove card.
     *
     * @param card the card
     */
    public void removeCard(Ability<Player, Monster> card) {
        this.hand.remove(card);
        // TODO: 25.03.22 there were some weird exceptions with cards maybe ask Johannes because I did not get it.
    }

    /**
     * Add card.
     *
     * @param card the card
     */
    public void addCard(Ability<Player, Monster> card) {
        this.hand.add(card);
    }

    /**
     * Gets dice.
     *
     * @return the dice
     */
    public Dice getDice() {
        return this.dice;
    }

    /**
     * Gets next dice.
     */
    public void getNextDice() {
        assert !dice.isLast(); // TODO: 25.03.22 Needs to be checked above?
        this.dice = Dice.values()[dice.ordinal() + 1];
    }


    /**
     * Is reflect boolean.
     *
     * @return the boolean
     */
    public boolean isReflect() {
        return reflect;
    }

    /**
     * Sets reflect.
     *
     * @param reflect the reflect
     */
    public void setReflect(final boolean reflect) {
        this.reflect = reflect;
    }

    @Override
    public void reset() {
        super.reset();
        this.setReflect(false);
    }

    /**
     * Heal.
     *
     * @param heal the heal
     */
    public void heal(final int heal) {
        this.healthPoints += heal;
        if (this.healthPoints > this.getMaxHealth()) {
            this.healthPoints = this.getMaxHealth();
        }
    }


    /**
     * Upgrades the players starting-cards to level and adds removed starting cards back to the players hand.
     *
     */
    public void upgradeCards(final int level) {
        // TODO: 27.03.22 make pretty
        for (var card : startingCards) {
            addCard(card.getLevel(level));
        }
    }
}
