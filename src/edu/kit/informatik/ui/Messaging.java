package edu.kit.informatik.ui;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Cards.Dice;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.ui.prompts.Prompt;
import edu.kit.informatik.ui.prompts.SelectPrompt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Output Interface is responsible for printing Messages to the User that are not prompts for input. We did not make
 * this class static to leave open the possibility of polymorphism in the interface.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class Messaging {

    //Messages
    private static final String LINE_STRING = "----------------------------------------";
    private static final String DISCARD_CARDS = "%s (%s) can discard ability cards for healing (or none)";
    private static final int MIN_CARDS = 0;
    private static final String NEW_STAGE_REGEX = "%s enters Stage %d of Level %d";
    private static final String VS = "vs.";
    private static final String STATUS_MESSAGE = "%s (%s, %s)";
    private static final String ATTEMPTS_NEXT = "%s: attempts %s next";
    private static final String USE = "%s uses %s";
    private static final String DAMAGE_MESSAGE = "%s takes %d %s damage";
    private static final String S_GETS_S = "%s gets %s";
    private static final String DIE_MESSAGE = "%s dies";
    private static final String WON_MESSAGE = "%s won!";
    private static final String SELECT_S_TARGET = "Select %s's target.";
    private static final String GAINS_HEALTH = "%s gains %d health";
    private static final String WELCOME_TO_RUNA_S_STRIVE = "Welcome to Runa's Strive";


    /**
     * Instantiates a new Output inter face.
     */
    public Messaging() {
    }

    /**
     * Print stage.
     *
     * @param player the player
     * @param stage  the stage
     * @param level  the level
     */
    public void printStage(Player player, int stage, int level) {
        println(getStageRepresentation(player, stage, level));
    }

    private String getStageRepresentation(final Player player, final int stage, final int level) {
        return String.format(NEW_STAGE_REGEX, player.getName(), stage, level);
    }

    /**
     * Print status.
     *
     * @param player   the player
     * @param monsters the monsters
     */
    public void printStatus(Player player, List<Monster> monsters) {
        println(LINE_STRING);
        println(agentToStatus(player));
        println(VS);
        for (Monster monster : monsters) {
            // TODO: 14.03.22 sort?
            println(monsterToStatus(monster));
        }
        println(LINE_STRING);
    }

    private String agentToStatus(Agent<?, ?> agent) {
        return String.format(STATUS_MESSAGE, agent.getName(), agent.getHealthStatus(), agent.getFocusPointStatus());
    }

    private String monsterToStatus(Monster monster) {
        return String.format(ATTEMPTS_NEXT, agentToStatus(monster), monster.getNextAbility().toString());
    }

    /**
     * Print usage.
     *
     * @param agent   the agent
     * @param ability the ability
     */
    // TODO: 26.03.22 maybe change all the print names to something like display?
    public void printUsage(Agent<?, ?> agent, final Ability<?, ?> ability) {
        println(String.format(USE, agent.getName(), ability.toString()));
    }

    /**
     * Print damage.
     *
     * @param damage the damage
     * @param agent  the agent
     */
    public void printDamage(final Damage damage, final Agent<?, ?> agent) {
        printIfNotZero(String.format(DAMAGE_MESSAGE, agent.toString(), damage.getAmount(), damage.getType()),
                damage.getAmount());
    }

    /**
     * Gets card.
     *
     * @param player the player
     * @param card   the card
     */
    public void getCard(final Player player, final Ability<?, ?> card) {
        println(String.format(S_GETS_S, player, card.toString()));
    }


    /**
     * Dies.
     *
     * @param agent the agent
     */
    public void dies(final Agent<?, ?> agent) {
        println(String.format(DIE_MESSAGE, agent));
    }

    /**
     * Won.
     *
     * @param player the player
     */
    public void won(final Player player) {
        println(String.format(WON_MESSAGE, player));
    }

    /**
     * Heal list.
     *
     * @param player the player
     * @param healPerCard
     * @return the list
     */
    public List<Ability<Player, Monster>> heal(final Player player, final int healPerCard) {

        // TODO: 26.03.22 none does not work. Needs prompt?
        int maxCardThroughHeal = player.getMaxHealth() - player.getHealthPoints() / healPerCard;
        final int maxCards = Math.min(maxCardThroughHeal, player.getHand().size() - 1);
        Prompt<Ability<Player, Monster>> healingPrompt = new SelectPrompt<>(
                String.format(DISCARD_CARDS, player, player.getHealthStatus()), player.getHand(), MIN_CARDS,
                maxCards); //
        var cards = healingPrompt.parseList();
        // TODO: 26.03.22 do the healingThing correctly
        if (cards == null) {
            return null;
        }
        return new ArrayList<>(cards);
    }

    /**
     * Gets target.
     *
     * @param player          the player
     * @param currentMonsters the current monsters
     * @return the target
     */
    public Monster getTarget(final Player player, final List<Monster> currentMonsters) {
        Prompt<Monster> monsterPrompt = new SelectPrompt<>(selectTarget(player), currentMonsters, false);
        return monsterPrompt.parseItem();
    }
    private String selectTarget(final Player player) {
        return String.format(SELECT_S_TARGET, player.getName());
    }

    /**
     * Print heal.
     *
     * @param player     the player
     * @param healthGain the health gain
     */
    public void printHeal(final Player player, final int healthGain) {
        printIfNotZero(getHeal(player, healthGain), healthGain);
    }

    private String getHeal(final Player player, final int healthGain) {
        return String.format(GAINS_HEALTH, player, (healthGain));
    }

    /**
     * Focus.
     *
     * @param agent  the agent
     * @param points the points
     */
    public void focus(final Agent<?, ?> agent, final int points) {
        printIfNotZero(gainFocus(agent, points), points);
    }

    private void printIfNotZero(String string, int value) {
        if (value != 0) {
            println(string);
        }
    }

    private String gainFocus(final Agent<?, ?> agent, final int points) {
        return String.format("%s gains %d focus", agent, points);
    }

    /**
     * Println. Custom print function
     *
     * @param string the string
     */
    public void println(String string) {
        // TODO: 27.03.22 does this make sense with check?
        if (SelectPrompt.isRunning() && !Objects.equals(string, "")) {
            System.out.println(string);
        }
    }

    /**
     * Welcome
     */
    public void welcome() {
        println(WELCOME_TO_RUNA_S_STRIVE);
    }

    /**
     * Upgrade.
     *
     * @param aggressor the aggressor
     * @param dice      the dice
     */
    public void upgrade(final Player aggressor, final Dice dice) {
        println(String.format("%s upgrades her die to a %s", aggressor, dice));
    }
}
