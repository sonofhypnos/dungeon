package edu.kit.informatik.model.Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * The type Card deck.
 *
 * @param <T> the type parameter
 * @author upkim
 * @version 1.0.0 10.03.22
 */
public class CardDeck<T> {
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
     * Draw t.
     *
     * @return the t
     */
    public T draw() {
        return this.cards.remove(0);
    }

    public List<T> draw(int n){
        List<T> values = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            values.add(draw());
        }
        return values;
    }
}
