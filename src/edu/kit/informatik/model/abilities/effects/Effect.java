package edu.kit.informatik.model.abilities.effects;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.ui.OutputInterFace;
import edu.kit.informatik.ui.prompts.DiceRoll;
import edu.kit.informatik.ui.prompts.Prompt;
import edu.kit.informatik.ui.prompts.SelectPrompt;
import java.util.List;

/**
 * @author upkim
 * @version 1.0.0 11.03.22
 */
public abstract class Effect<A, B> {
    protected OutputInterFace interFace;
    private int roll;
    private B target;

    public Effect() {
        this.interFace = new OutputInterFace();
    }

    public abstract void applyEffect(A aggressor, B target);


    public B getTarget() {
        return target;
    }

    public void setTarget(final B target) {
        this.target = target;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(final int roll) {
        this.roll = roll;
    }

}

