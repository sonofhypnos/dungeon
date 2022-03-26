package edu.kit.informatik.model.abilities.player;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityKind;
import edu.kit.informatik.model.abilities.Focus;

public enum PlayerAbilities implements AbilityKind {
    SLASH(new Slash("Slash", Constants.INITIAL_LEVEL)),
    SWING(new Swing("Swing", Constants.INITIAL_LEVEL)),
    THRUST(new Thrust("Thrust", Constants.INITIAL_LEVEL)),
    PIERCE(new Pierce("Pierce", Constants.INITIAL_LEVEL)),
    PARRY(new Parry("Parry", Constants.INITIAL_LEVEL)),
    FOCUS(new Focus<>(Constants.INITIAL_LEVEL)),
    REFLECT(new Reflect("Reflect", Constants.INITIAL_LEVEL)),
    WATER(new Water("Water", Constants.INITIAL_LEVEL)),
    ICE(new Ice("Ice", Constants.INITIAL_LEVEL)),
    FIRE(new Fire("Fire", Constants.INITIAL_LEVEL)),
    LIGHTNING(new Lightning("Lightning", Constants.INITIAL_LEVEL));
    // TODO: 26.03.22 there are the wrong cards to be seen on the screen

    private final Ability<Player, Monster> ability;

    PlayerAbilities(final Ability<Player, Monster> ability) {
        ability.setIdentifier(this);
        this.ability = ability;
    }

    public Ability<Player, Monster> getAbility() {
        return ability;
    }

    @Override
    public String toString() {
        return this.ability.toString();
    }
}


















































