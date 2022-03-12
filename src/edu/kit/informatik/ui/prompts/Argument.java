package edu.kit.informatik.ui.prompts;

/**
 * @author upkim
 * @version 1.0.0 10.03.22
 */
public interface Argument <P> {
    public P parse(String str);
}
