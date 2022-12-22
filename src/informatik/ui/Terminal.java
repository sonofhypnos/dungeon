package informatik.ui;

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
 * The Terminal class is responsible for printing messages to the User that are not prompts for input.
 *
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public final class Terminal {

    //Messages
    private static final String LINE_STRING = "----------------------------------------";
    private static final String DISCARD_CARDS = "%s (%s) can discard ability cards for healing (or none)";
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
    private static final String DIE_UPGRADE = "%s upgrades her die to a %s";
    private static final String GAINS_D_FOCUS = "%s gains %d focus";


    /**
     * Private constructor for utility class
     */
    private Terminal() {
    }

    /**
     * Print stage.
     *
     * @param player the player
     * @param stage  the stage
     * @param level  the level
     */
    public static void printStage(Player player, int stage, int level) {
        println(getStageRepresentation(player, stage, level));
    }

    private static String getStageRepresentation(final Player player, final int stage, final int level) {
        return String.format(NEW_STAGE_REGEX, player.getName(), stage, level);
    }

    /**
     * Print status.
     *
     * @param player   the player
     * @param monsters the monsters
     */
    public static void printStatus(Player player, List<Monster> monsters) {
        println(LINE_STRING);
        println(agentToStatus(player));
        println(VS);
        for (Monster monster : monsters) {
            println(monsterToStatus(monster));
        }
        println(LINE_STRING);
    }

    private static String agentToStatus(Agent agent) {
        return String.format(STATUS_MESSAGE, agent.getName(), agent.getHealthStatus(), agent.getFocusPointStatus());
    }

    private static String monsterToStatus(Monster monster) {
        return String.format(ATTEMPTS_NEXT, agentToStatus(monster), monster.getNextAbility().toString());
    }

    /**
     * Print usage.
     *
     * @param agent   the agent
     * @param ability the ability
     */
    public static void printUsage(Agent agent, final Ability<?, ?> ability) {
        println(String.format(USE, agent.getName(), ability.toString()));
    }

    /**
     * Print damage.
     *
     * @param damage the damage
     * @param agent  the agent
     */
    public static void printDamage(final Damage damage, final Agent agent) {
        printIfNotZero(String.format(DAMAGE_MESSAGE, agent.toString(), damage.getAmount(), damage.getType()),
                damage.getAmount());
    }

    /**
     * Gets card.
     *
     * @param player the player
     * @param card   the card
     */
    public static void getCard(final Player player, final Ability<?, ?> card) {
        println(String.format(S_GETS_S, player, card.toString()));
    }


    /**
     * Dies.
     *
     * @param agent the agent
     */
    public static void dies(final Agent agent) {
        println(String.format(DIE_MESSAGE, agent));
    }

    /**
     * Won.
     *
     * @param player the player
     */
    public static void won(final Player player) {
        println(String.format(WON_MESSAGE, player));
    }

    /**
     * Heal returns cards sacrificed for healing. Also does some commandlien output related to healing
     *
     * @param player      the player
     * @param healPerCard the heal per card
     * @return the list
     */
    public static List<Ability<Player, Monster>> heal(final Player player, final int healPerCard) {

        int maxCardThroughHeal = player.getMaxHealth() - player.getHealthPoints() / healPerCard;
        final int maxCards = Math.min(maxCardThroughHeal, player.getHand().size() - 1);
        Prompt<Ability<Player, Monster>> healingPrompt = new SelectPrompt<>(
                String.format(DISCARD_CARDS, player, player.getHealthStatus()), player.getHand(), 0, maxCards); //
        var cards = healingPrompt.parseList();
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
    public static Monster getTarget(final Player player, final List<Monster> currentMonsters) {
        Prompt<Monster> monsterPrompt = new SelectPrompt<>(selectTarget(player), currentMonsters);
        return monsterPrompt.parseItem();
    }

    private static String selectTarget(final Player player) {
        return String.format(SELECT_S_TARGET, player.getName());
    }

    /**
     * Print heal.
     *
     * @param player     the player
     * @param healthGain the health gain
     */
    public static void printHeal(final Player player, final int healthGain) {
        printIfNotZero(getHeal(player, healthGain), healthGain);
    }

    private static String getHeal(final Player player, final int healthGain) {
        return String.format(GAINS_HEALTH, player, (healthGain));
    }

    /**
     * Focus.
     *
     * @param agent  the agent
     * @param points the points
     */
    public static void focus(final Agent agent, final int points) {
        printIfNotZero(gainFocus(agent, points), points);
    }

    private static void printIfNotZero(String string, int value) {
        if (value != 0) {
            println(string);
        }
    }

    private static String gainFocus(final Agent agent, final int points) {
        return String.format(GAINS_D_FOCUS, agent, points);
    }

    /**
     * Println. Custom print function
     *
     * @param string the string
     */
    public static void println(String string) {
        if (SelectPrompt.isRunning() && !Objects.equals(string, "")) {
            System.out.println(string);
        }
    }

    /**
     * Welcome
     */
    public static void welcome() {
        println(WELCOME_TO_RUNA_S_STRIVE);
    }

    /**
     * Upgrade.
     *
     * @param aggressor the aggressor
     * @param dice      the dice
     */
    public static void upgrade(final Player aggressor, final Dice dice) {
        println(String.format(DIE_UPGRADE, aggressor, dice));
    }
}
