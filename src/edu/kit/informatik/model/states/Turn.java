package edu.kit.informatik.model.states;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.Cards.abilities.Ability;
import edu.kit.informatik.model.GameContext;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.ui.OutputInterFace;
import edu.kit.informatik.ui.prompts.Prompt;
import edu.kit.informatik.ui.prompts.SelectPrompt;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class Turn implements GameState {
    private static final String SELECT_CARD_TO_PLAY = "Select Card to play";
    private final FightingLevel fight;
    private Prompt<Ability<Player,List<Monster>>> abilityPrompt;


    //private final GameInitializer runa;


    public Turn(final FightingLevel fight) {
        this.fight = fight;
    }

    @Override
    public void prompt() {
        // TODO: 14.03.22 write something to make a sequence of prompts less awekward?

        var interFace = new OutputInterFace();

        abilityPrompt = new SelectPrompt<>(SELECT_CARD_TO_PLAY, fight.getPlayer().getCards());
        abilityPrompt = OutputInterFace.selectCardsToPlay(fight.getPlayer().getCards());
        // TODO: 23.03.22 ich probiere das mit outputInterface hier mal aus. bin nicht überzeugt.
        abilityPrompt.prompt();
    }

    @Override
    public void run(final String input, final GameContext runa) {
        var ability = abilityPrompt.parse(input);
        ability.applyEffect(this.fight.getPlayer(), this.fight.getCurrentMonsters());

        // TODO: 23.03.22 check that game has not ended?
        this

    }
}
