package edu.kit.informatik.model.states;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Cards.abilities.Ability;
import edu.kit.informatik.model.GameInitializer;
import edu.kit.informatik.ui.prompts.Prompt;
import edu.kit.informatik.ui.prompts.SelectPrompt;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class RunaTurn implements GameState {
    private static final String SELECT_CARD_TO_PLAY = "Select Card to play";
    private Player player;
    private List<Monster> currentMonster;
    private Prompt<Ability> abilityPrompt;
    private Prompt<Integer> dicePrompt;
    private Prompt<Monster> targetPrompt;


    //private final GameInitializer runa;


    public RunaTurn(final Player player, final List<Monster> currentMonster) {

        this.player = player;
        this.currentMonster = currentMonster;
    }

    @Override
    public void prompt() {
        // TODO: 14.03.22 write something to make a sequence of prompts less awekward?
        abilityPrompt = new SelectPrompt<>(SELECT_CARD_TO_PLAY, player.getCards());
        abilityPrompt.prompt();

    }

    @Override
    public void run(final String input, final GameInitializer runa) {
        List<Ability> ability = abilityPrompt.parse(input);

    }
}
