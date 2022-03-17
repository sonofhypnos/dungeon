package edu.kit.informatik.model.Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * The type Card deck.
 *
 * @param <T> the type of the cards.
 * @author upkim
 * @version 1.0.0 10.03.22
 */
public class CardDeck<T> {
    private static final int DRAW_INDEX = 0;
    /**
     * The Cards.
     */
    List<T> cards;

    /**
     * Instantiates a new Card deck.
     *
     * @param cards the cards
     */
    public CardDeck(List<T> cards) {
        this.cards = new ArrayList<>(cards);
    }


    /**
     * Shuffle.
     *
     * @param seed the seed
     */
    public void shuffle(int seed) {
        Collections.shuffle(cards, new Random(seed));
    }

    /**
     * Draw item t. Removes t from the deck.
     *
     * @return the t
     */
    public T draw() {
        return this.cards.remove(DRAW_INDEX);
    }

    /**
     * Draw up to n cards from the deck. If the deck has less than n cards the remaining cards are returned and
     * the deck is emptied.
     *
     * @param n the n
     * @return the list
     */
    public List<T> draw(int n){
        List<T> values = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (this.cards.isEmpty()) {
                break;
            }
            values.add(draw());
        }
        return values;
    }
}
