package edu.kit.informatik.model.abilities.effects;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.ui.OutputInterFace;
import edu.kit.informatik.ui.prompts.Prompt;
import edu.kit.informatik.ui.prompts.SelectPrompt;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 11.03.22
 */
public abstract class Effect<A, B> {
    protected OutputInterFace interFace;

    public Effect() {
        this.interFace = new OutputInterFace();
    }

    public abstract void applyEffect(A aggressor, B target);

    protected Monster getTargetMonster(Player player, List<Monster> monsters) {
        player.roll();
        Prompt<Monster> monsterPrompt = new SelectPrompt<>(String.format("Select %s's target.", player.getName()),
                monsters);
        return monsterPrompt.parseItem();
    }
}

