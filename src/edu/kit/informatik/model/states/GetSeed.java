package edu.kit.informatik.model.states;

import edu.kit.informatik.model.GameContext;
import edu.kit.informatik.ui.prompts.Prompt;
import edu.kit.informatik.ui.prompts.SeedPrompt;

import java.util.List;

/**
 * The type Get seed.
 *
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class GetSeed implements GameState {
    private static final int SEED_NUMBER = 2;
    private final Prompt<List<Integer>> prompt;


    /**
     * Instantiates a new Get seed.
     */
    public GetSeed() {
        this.prompt = new SeedPrompt();
        prompt.prompt();
    }

    @Override
    public void prompt() {
        prompt.prompt();
    }

    @Override
    public void run(final String input, final GameContext runa) {
        List<Integer> seeds = prompt.parse(input);
        if (seeds == null || seeds.size() != SEED_NUMBER) {
            prompt.entryPrompt();
            return;
        }
        runa.setSeeds(seeds);
        runa.setGameState(new FightingLevel(runa));
    }
}
