package edu.kit.informatik.model.abilities.player;

import edu.kit.informatik.model.Cards.Monster;
import edu.kit.informatik.model.Cards.Player;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityKind;
import edu.kit.informatik.model.abilities.Focus;

/**
 * The enum Player abilities.
 */
public enum PlayerAbilities implements AbilityKind {
    /**
     * The Slash.
     */
    SLASH {
        @Override
        public Ability<Player, Monster> getAbility() {
            return new Slash("Slash", Constants.INITIAL_LEVEL, this);
        }
    },
    /**
     * The Swing.
     */
    SWING {
        @Override
        public Ability<Player, Monster> getAbility() {
            return new Swing("Swing", Constants.INITIAL_LEVEL, this);
        }
    },
    /**
     * The Thrust.
     */
    THRUST {
        @Override
        public Ability<Player, Monster> getAbility() {
            return new Thrust("Thrust", Constants.INITIAL_LEVEL, this);
        }
    },
    /**
     * The Pierce.
     */
    PIERCE {
        @Override
        public Ability<Player, Monster> getAbility() {
            return new Pierce("Pierce", Constants.INITIAL_LEVEL, this);
        }
    },
    /**
     * The Parry.
     */
    PARRY {
        @Override
        public Ability<Player, Monster> getAbility() {
            return new Parry("Parry", Constants.INITIAL_LEVEL, this);
        }
    },
    /**
     * The Focus.
     */
    FOCUS {
        @Override
        public Ability<Player, Monster> getAbility() {
            return new Focus<>(Constants.INITIAL_LEVEL, this);
        }
    },
    /**
     * The Reflect.
     */
    REFLECT {
        @Override
        public Ability<Player, Monster> getAbility() {
            return new Reflect("Reflect", Constants.INITIAL_LEVEL, this);
        }
    },
    /**
     * The Water.
     */
    WATER {
        @Override
        public Ability<Player, Monster> getAbility() {
            return new Water("Water", Constants.INITIAL_LEVEL, this);
        }
    },
    /**
     * The Ice.
     */
    ICE {
        @Override
        public Ability<Player, Monster> getAbility() {
            return new Ice("Ice", Constants.INITIAL_LEVEL, this);
        }
    },
    /**
     * The Fire.
     */
    FIRE {
        @Override
        public Ability<Player, Monster> getAbility() {
            return new Fire("Fire", Constants.INITIAL_LEVEL, this);
        }
    },
    /**
     * The Lightning.
     */
    LIGHTNING {
        @Override
        public Ability<Player, Monster> getAbility() {
            return new Lightning("Lightning", Constants.INITIAL_LEVEL, this);
        }
    };
    // TODO: 26.03.22 there are the wrong cards to be seen on the screen

    /**
     * Gets ability.
     *
     * @return the ability
     */
    public abstract Ability<Player, Monster> getAbility();

    /**
     * Gets level.
     *
     * @param level the level
     * @return the level
     */
    public Ability<Player, Monster> getLevel(int level) {
        var newAbility = getAbility();
        newAbility.setLevel(level);
        return newAbility;
    }

    @Override
    public String toString() {
        return this.getAbility().toString();
    }
}
