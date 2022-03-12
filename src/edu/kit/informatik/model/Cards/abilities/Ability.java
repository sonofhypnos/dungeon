package edu.kit.informatik.model.Cards.abilities;

import edu.kit.informatik.model.Cards.Player;

/**
 * @author upkim
 * @version 1.0.0 11.03.22
 */
public abstract class Ability implements Effect{
    private AbilityKind kind;

    public boolean isKind(AbilityNames other) {
        return kind.equals(other);
    }

    public void setKind(AbilityKind kind) {
        this.kind = kind;
    }

    @Override
    public <A extends Player, B extends Player> void applyEffect(final A aggressor, final B target) {
        throw new UnsupportedOperationException("");

    }
}
