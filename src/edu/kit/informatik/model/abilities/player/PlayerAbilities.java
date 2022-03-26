package edu.kit.informatik.model.abilities.player;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityKind;
import edu.kit.informatik.model.abilities.Focus;

public enum PlayerAbilities implements AbilityKind {
    SLASH(new Slash("Slash", 0)),
    SWING(new Swing("Swing", 0)),
    THRUST(new Thrust("Thrust", 0)),
    PIERCE(new Pierce("Pierce", 0)),
    PARRY(new Parry("Parry", 0)),
    FOCUS(new Focus<>(0)),
    REFLECT(new Reflect("Reflect", 0)),
    WATER(new Water("WaterPlayer", 0)),
    ICE(new Ice("IcePlayer", 0)),
    FIRE(new Fire("FirePlayer", 0)),
    LIGHTNING(new Lightning("LightningPlayer", 0));

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


















































