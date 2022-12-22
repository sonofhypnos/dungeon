package informatik.model.Cards;

/**
 * The enum Dice.
 *
 * @author upkim
 * @version 1.0.0 2022-03-14
 */
public enum Dice {
    /**
     * D 4 dice.
     */
    D4("d4", 4),
    /**
     * D 6 dice.
     */
    D6("d6", 6),
    /**
     * D 8 dice.
     */
    D8("d8", 8),
    /**
     * D 10 dice.
     */
    D10("d10", 10),
    /**
     * D 12 dice.
     */
    D12("d12", 12);

    private final int value;
    private final String name;

    /**
     * private Constructor for new Dice object.
     *
     * @param name  name of dice
     * @param value value of dice.
     */
    Dice(final String name, final int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Is last boolean.
     *
     * @return the boolean
     */
    public boolean isLast() {
        return this.equals(Dice.D12);
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}
