package edu.kit.informatik.ui.prompts;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Cards.Monster;

import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-11
 */
public class PrintStatus {
    private static final String LINE_STRING = "----------------------------------------";
    // TODO: 14.03.22 Make actually abstract functions to implement stuff from monster and agent (for UI?)
    private final List<Monster> monsters;
    private final Player player;

    public PrintStatus(Player player, List<Monster> monsters) {
        this.player = player;
        this.monsters = monsters;

    }

    public void printStage(int stage, int level) {
        System.out.printf("%s Enters Stage %d of Level %d%n", player.getName(), stage, level);
    }

    public void printStatus() {
        System.out.println(LINE_STRING);
        System.out.println(agentToStatus(player));
        System.out.println("vs.");
        for (Monster monster: monsters) {
            // TODO: 14.03.22 sort?
            System.out.println(monster);
        }
        System.out.println(LINE_STRING);
    }

    private String agentToStatus(Agent agent){
        return String.format("%s (%s HP, %s FP)", agent.getName(), agent.getHealthStatus(),
                agent.getFocusPointStatus());
    }

    private String monsterToStatus(Monster monster){
        return String.format("%s attempts %s next", agentToStatus(monster), monster.getNextAbility().toString());
    }


    // TODO: 14.03.22 do the thing you did in getString but just do it sepseparately because you can distinguish the
    //  two here actually (just use the non-generic function and feed it into generic one.

}
