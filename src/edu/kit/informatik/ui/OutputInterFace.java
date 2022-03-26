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
    private static final int NEGLIGABLE_DAMAGE = 0;
    private static final String DISCARD_CARDS = "%s (%s) can discard ability cards for healing (or none)";
    // TODO: 14.03.22 Make actually abstract functions to implement stuff from monster and agent (for UI?)

    public OutputInterFace() {
        // TODO: 18.03.22 ist es erlaubt Runtime aufzurufen?
    }
    // TODO: 25.03.22 the programmieren guide doesn't like direct output of string stuff. Therefore make a
    //  sepseparate method that creates a string for each

    public void printStage(Player player, int stage, int level) {
        System.out.printf("%s enters Stage %d of Level %d%n", player.getName(), stage, level);
    }

    public void printStatus(Player player, List<Monster> monsters) {
        System.out.println(LINE_STRING);
        System.out.println(agentToStatus(player));
        System.out.println("vs.");
        for (Monster monster : monsters) {
            // TODO: 14.03.22 sort?
            System.out.println(monsterToStatus(monster));
        }
        System.out.println(LINE_STRING);
    }

    private String agentToStatus(Agent<?, ?> agent) {
        return String.format("%s (%s, %s)", agent.getName(), agent.getHealthStatus(), agent.getFocusPointStatus());
    }

    private String monsterToStatus(Monster monster) {
        return String.format("%s: attempts %s next", agentToStatus(monster), monster.getNextAbility().toString());
    }

    // TODO: 26.03.22 maybe change all the print names to something like display?
    public void printUsage(Agent<?, ?> agent, final Ability<?, ?> ability) {
        System.out.printf("%s uses %s%n", agent.getName(), ability.toString());
    }

    public void printDamage(final Damage damage, final Agent<?, ?> agent) {
        if (damage.getAmount() == NEGLIGABLE_DAMAGE) {
            return;
        }
        System.out.printf("%s takes %d %s damage%n", agent.toString(), damage.getAmount(), damage.getType());
    }

    public void getCard(final Player player, final Ability<?, ?> card) {
        System.out.printf("%s gets %s%n", player, card.toString());
    }

    public void dies(final Agent<?, ?> agent) {
        System.out.printf("%s dies%n", agent);
    }

    public void won(final Player player) {
        System.out.printf("%s won!%n", player);
    }

    public List<Ability<Player, Monster>> heal(final Player player) {

        // TODO: 26.03.22 none does not work. Needs prompt?
        Prompt<Ability<Player, Monster>> healingPrompt = new SelectPrompt<>(
                String.format(DISCARD_CARDS, player.toString(), player.getHealthStatus()), player.getCards(),
                NEGLIGABLE_DAMAGE, player.getCards().size() - 1); //
        return new ArrayList<>(healingPrompt.parseList());
    }

    public Monster getTarget(final Player player, final List<Monster> currentMonsters) {
        Prompt<Monster> monsterPrompt = new SelectPrompt<>(selectTarget(player), currentMonsters);
        return monsterPrompt.parseItem();
    }

    private String selectTarget(final Player player) {
        return String.format("Select %s's target.", player.getName());
    }

    public void printHeal(final Player player, final int healthPrev) {
        System.out.println(getHeal(player, healthPrev));

    }

    private String getHeal(final Player player, final int healthPrev) {
        return String.format("%s gains %d health", player, (player.getHealthPoints() - healthPrev));
    }

    public void focus(final Agent<?, ?> agent, final int points) {
        System.out.println(gainFocus(agent, points));
    }

    private String gainFocus(final Agent<?, ?> agent, final int points) {
        return String.format("%s gains %d focus", agent, points);
    }


    // TODO: 14.03.22 do the thing you did in getString but just do it sepseparately because you can distinguish the
    //  two here actually (just use the non-generic function and feed it into generic one.

}
