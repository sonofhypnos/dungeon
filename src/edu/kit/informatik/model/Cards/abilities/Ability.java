package edu.kit.informatik.model.Cards.abilities;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import java.util.Objects;

/**
 * @author upkim
 * @version 1.0.0 11.03.22
 */
public abstract class Ability implements Effect {
    protected AbilityKind type;
    protected AbilityKind kind;
    protected String name;
    protected int level;

    public AbilityKind getKind() {
        return kind;
    }

    //    public boolean isKind(AbilityNames other) {
    //        return kind.equals(other);
    //    }
    //
    //    public void setKind(AbilityKind kind) {
    //        this.kind = kind;
    //    }

    public abstract boolean canBeUsed(Player p, Monster m);

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Ability)) return false;
        Ability ability = (Ability) o;
        return kind.equals(ability.kind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind);
    }

    // TODO: 14.03.22 setLevel?
}
