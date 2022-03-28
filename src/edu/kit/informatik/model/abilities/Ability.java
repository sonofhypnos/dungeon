package edu.kit.informatik.model.abilities;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.abilities.effects.Effect;
import java.util.Objects;

/**
 * Ability class provides common functionality between abilities
 *
 * @param <A> the type parameter
 * @param <T> the type parameter
 * @author upkim
 * @version 1.0.0 11.03.22
 */
public abstract class Ability<A, T> extends Effect<A, T> {
    private static final String ABILITY_STRING = "%s(%d)";
    /**
     * The Type.
     */
    protected AbilityType type;
    /**
     * The Identifier.
     */
    protected AbilityKind identifier;
    /**
     * The Name.
     */
    protected String name;
    /**
     * The Level.
     */
    protected int level;
    private boolean needsDice;

    /**
     * Instantiates a new Ability.
     *
     * @param name  the name
     * @param level the level
     * @param type  the type
     */
    protected Ability(String name, int level, AbilityType type) {
        super();
        this.name = name;
        this.level = level;
        this.type = type;
    }

    /**
     * Instantiates a new Ability.
     *
     * @param name  the name
     * @param level the level
     * @param type  the type
     * @param kind  the kind
     */
    protected Ability(String name, int level, AbilityType type, AbilityKind kind) {
        super();
        this.name = name;
        this.level = level;
        this.type = type;
        this.identifier = kind;
    }

    /**
     * Sets level.
     *
     * @param level the level
     */
    public void setLevel(final int level) {
        this.level = level;
    }

    /**
     * Is type boolean.
     *
     * @param type the type
     * @return the boolean
     */
    public boolean isType(AbilityType type) {
        if (this.type == null) {
            return false;
        }
        return this.type.equals(type);
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Ability)) return false;
        Ability<?, ?> ability = (Ability<?, ?>) o;
        if (identifier == null) return false;
        return identifier.equals(ability.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }

    @Override
    public String toString() {
        return String.format(ABILITY_STRING, getName(), level);
    }

    @Override
    public abstract void applyEffect(A aggressor, T target);

    /**
     * Can be used boolean.
     *
     * @param agent the agent
     * @return the boolean
     */
    public boolean canBeUsed(Agent agent) {
        return true;
    }


    /**
     * Needs dice boolean.
     *
     * @return the boolean
     */
    public boolean needsDice() {
        return needsDice;
    }

    /**
     * Sets dice need.
     *
     * @param needsDice the needs dice
     */
    public void setDiceNeed(final boolean needsDice) {
        this.needsDice = needsDice;
    }

}

