package edu.kit.informatik.model.states;

import edu.kit.informatik.model.Archetype;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.GameContext;
import edu.kit.informatik.ui.prompts.SelectPrompt;

import java.util.List;

/**
 * The type Sel class.
 *
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class SelectClass implements GameState {

    private static final String SELECT_PLAYER_S_CHARACTER_CLASS = "Select %s's character class";
    private final SelectPrompt<Archetype> selection;
    private final Player player;


    /**
     * Instantiates a new Sel class.
     *
     * @param player the player
     */
    public SelectClass(Player player) {
        this.selection = new SelectPrompt<>(String.format(SELECT_PLAYER_S_CHARACTER_CLASS, player.getName()),
                List.of(Archetype.values()));
        this.player = player;
    }

    @Override
    public void prompt() {
        selection.prompt();
    }

    @Override
    public void run(final String input, final GameContext runa) {
        Archetype c = selection.parse(input);
            if (c == null){

            selection.entryPrompt();
            return;
        }
        this.player.setClass(c);
        runa.setGameState(new GetSeed());
    }
}
