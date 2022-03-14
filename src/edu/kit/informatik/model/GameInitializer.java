package edu.kit.informatik.model;

import edu.kit.informatik.model.Cards.*;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.states.GameState;
import edu.kit.informatik.model.states.SelectClass;

import java.util.List;

/**
 *
 * @author Moritz Hertler
 * @version 1.0
 */
public class GameInitializer {

    /**
     * The constant PLAYER.
     */
    private final PlayerDeck playerDeck = new PlayerDeck();

    public Player getPlayer() {
        return player;
    }

    private final Player player;
    private List<Integer> seeds;
    private GameState gameState;
    private MonsterDeck monsterDeck;
    // TODO: 11.03.22 guarantee states are immutable?


    /**
     * Instantiates a new Runa.
     */
    public GameInitializer() {
        player = new Player("Runa");
        this.gameState = new SelectClass(player);
    }

    /**
     * Sets game state.
     *
     * @param gameState the game state
     */
    public void setGameState(final GameState gameState) {
        this.gameState = gameState;
    }

    /**
     * Process.
     *
     * @param input the input
     */
    public void run(final String input) {
        this.gameState.run(input, this);
    }

    /**
     * Next.
     */
    public void prompt() {
        this.gameState.prompt();
    }

    /**
     * Sets seeds.
     *
     * @param seeds the seeds
     */
    public void setSeeds(final List<Integer> seeds) {
        this.seeds = seeds;
    }

    public void shuffle(int level) {
        monsterDeck = new MonsterDeck(level);
        playerDeck.shuffle(seeds.get(0));
        monsterDeck.shuffle(seeds.get(1));
    }

    public List<Monster> drawMonster(int n) {
        return monsterDeck.draw(n);
    }
}
