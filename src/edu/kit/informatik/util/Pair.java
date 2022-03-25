package edu.kit.informatik.util;

/**
 * @author upkim
 * @version 1.0.0 2022-03-25
 */
public class Pair <F, S> {
    private final F first;
    private final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }


    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }
}
