package edu.kit.informatik.ui;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Damage;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.ui.prompts.Prompt;
import edu.kit.informatik.ui.prompts.SelectPrompt;
import java.util.ArrayList;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class OutputInterFace {

    private static final String LINE_STRING = "----------------------------------------";
    private static final String DISCARD_CARDS = "%s (%s) can discard ability cards for healing (or none)";
    private static final int MIN_CARDS = 0;
    // TODO: 14.03.22 Make actually abstract functions to implement stuff from monster and agent (for UI?)


    public OutputInterFace() {
        // TODO: 18.03.22 ist es erlaubt Runtime aufzurufen?
    }
    // TODO: 25.03.22 the programmieren guide doesn't like direct output of string stuff. Therefore make a
    //  sepseparate method that creates a string for each

    public void printStage(Player player, int stage, int level) {
        println(String.format("%s enters Stage %d of Level %d", player.getName(), stage, level));
    }

    public void printStatus(Player player, List<Monster> monsters) {
        println(LINE_STRING);
        println(agentToStatus(player));
        println("vs.");
        for (Monster monster : monsters) {
            // TODO: 14.03.22 sort?
            println(monsterToStatus(monster));
        }
        println(LINE_STRING);
    }

    private String agentToStatus(Agent<?, ?> agent) {
        return String.format("%s (%s, %s)", agent.getName(), agent.getHealthStatus(), agent.getFocusPointStatus());
    }

    private String monsterToStatus(Monster monster) {
        return String.format("%s: attempts %s next", agentToStatus(monster), monster.getNextAbility().toString());
    }

    // TODO: 26.03.22 maybe change all the print names to something like display?
    public void printUsage(Agent<?, ?> agent, final Ability<?, ?> ability) {
        println(String.format("%s uses %s", agent.getName(), ability.toString()));
    }

    public void printDamage(final Damage damage, final Agent<?, ?> agent) {
        printIfPositive(String.format("%s takes %d %s damage", agent.toString(), damage.getAmount(),
                damage.getType()), damage.getAmount());
    }

    public void getCard(final Player player, final Ability<?, ?> card) {
        println(String.format("%s gets %s", player, card.toString()));
    }

    public void dies(final Agent<?, ?> agent) {
        println(String.format("%s dies", agent));
    }

    public void won(final Player player) {
        println(String.format("%s won!", player));
    }

    public List<Ability<Player, Monster>> heal(final Player player) {

        // TODO: 26.03.22 none does not work. Needs prompt?
        Prompt<Ability<Player, Monster>> healingPrompt = new SelectPrompt<>(
                String.format(DISCARD_CARDS, player.toString(), player.getHealthStatus()), player.getHand(), MIN_CARDS,
                player.getHand().size() - 1); //
        var cards = healingPrompt.parseList();
        // TODO: 26.03.22 do the healingThing correctly
        if (cards == null) {
            return null;
        }
        return new ArrayList<>(cards);
    }

    public Monster getTarget(final Player player, final List<Monster> currentMonsters) {
        Prompt<Monster> monsterPrompt = new SelectPrompt<>(selectTarget(player), currentMonsters);
        return monsterPrompt.parseItem();
    }

    private String selectTarget(final Player player) {
        return String.format("Select %s's target.", player.getName());
    }

    public void printHeal(final Player player, final int healthGain) {
        printIfPositive(getHeal(player, healthGain), healthGain);
    }

    private String getHeal(final Player player, final int healthGain) {
        return String.format("%s gains %d health", player, (healthGain));
    }

    public void focus(final Agent<?, ?> agent, final int points) {
        // TODO: 26.03.22 make pretty (isFocusing check again)
        printIfPositive(gainFocus(agent, points), points);
    }

    private void printIfPositive(String string, int value) {
        if (value != 0) {
            println(string);
        }
    }

    private String gainFocus(final Agent<?, ?> agent, final int points) {
        return String.format("%s gains %d focus", agent, points);
    }

    private void println(String string) {
        if (SelectPrompt.isRunning()) {
            System.out.println(string);
        }
    }


    // TODO: 14.03.22 do the thing you did in getString but just do it sepseparately because you can distinguish the
    //  two here actually (just use the non-generic function and feed it into generic one.

}
