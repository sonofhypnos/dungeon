package edu.kit.informatik.model.abilities;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.abilities.effects.Effect;
import java.util.Objects;

/**
 * @author upkim
 * @version 1.0.0 11.03.22
 */
public abstract class Ability<A, T> extends Effect<A, T> {
    // TODO: 17.03.22 add type to constructor
    protected AbilityType type;
    protected AbilityKind identifier;
    protected String name;
    protected int level;

    protected Ability(String name, int level, AbilityType type) {
        super();
        this.name = name;
        this.level = level;
        this.type = type;
    }

    protected Ability(int level) {

    }

    public void setIdentifier(final AbilityKind identifier) {
        this.identifier = identifier;
    }

    public void setLevel(final int level) {
        this.level = level;
    }


    // TODO: 15.03.22 make enum to

    public boolean isType(AbilityType type) {
        if (this.type == null) {
            return false;
        }
        return this.type.equals(type);
    }


    public String getName() {
        // TODO: 17.03.22 get name from identifier?
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Ability)) return false;
        Ability<?,?> ability = (Ability<?,?>) o;
        return identifier.equals(ability.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }

    @Override
    public String toString() {
        return String.format("%s(%d)", getName(), level);
    }

    @Override
    public abstract void applyEffect(final A aggressor, final T target);

    public boolean canBeUsed(Agent<?,?> agent){
        return true;
    }


    // TODO: 14.03.22 setLevel?
}

