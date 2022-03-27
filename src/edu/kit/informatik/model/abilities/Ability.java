package edu.kit.informatik.model.abilities;

import edu.kit.informatik.model.Agent;
import edu.kit.informatik.model.Runa;
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
    private boolean needsDice;

    protected Ability(String name, int level, AbilityType type) {
        super();
        this.name = name;
        this.level = level;
        this.type = type;
    }
    // TODO: 27.03.22
//- implement can be used
//    todos:
//            - 1,2,3,4 did not work with enter numbers!
//            - check starting cards
//- es gibt einen neuen Seed jede Runde?
//            - weird stuff happens if there is only one card left to draw!
//            - if edu.kit.informatik.model.Runa dies there should be no output.
//- skeleton takes not enough damage with ice
//- passe "Enter numer" prompt auf die Anzahl an Input an (no separated by comma)
//- es gibt ein Problem bei 0 cards
//- sind die physical damage bei Runa als Summe?
//            - wenn cards empty keine Karten mehr?
//            - haben die neuen karten immer das level vom level?
//            - kriegt man im Bosslevel überhaupt ...?
//            - update only Runas native cards (looks like everzthing got upgraded)
//- test interruption of focus?
//            - is boss level also only 1 card?
//            - no damage when using fire?
//            - make sure the healing works like it is supposed to (are you allowed to sacrifice to many cards?)
//- negative focus points!
//            - remove gains 0 health?
//            - add message about card update
//- Do I want to use effects to interact with the CLI?
//            - Ich muss noch "can be used" implementieren!
//            - when exactly should the focus stuff be berechnet and everything?
//            - attempts claw fähigkeit hat nicht die Nummer dazu
//- monster gain focus
//- grundsätzlich end of line?
//            - runa uses xyz should come before dice roll!
//            - mage1? might be bug in testing
    // TODO: 27.03.22 fix copy


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
        Ability<?, ?> ability = (Ability<?, ?>) o;
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

    public boolean canBeUsed(Agent<?, ?> agent) {
        return true;
    }


    // TODO: 26.03.22 make this in a way that effects inherit the needs of what they call?
    // TODO: 26.03.22 one could make a list of effects and each effect in turn has a list of characteristics that it
    //  needs
    public boolean needsDice() {
        return needsDice;
    }

    public void setDiceNeed(final boolean needsDice) {
        this.needsDice = needsDice;
    }

    // TODO: 14.03.22 setLevel?
}

