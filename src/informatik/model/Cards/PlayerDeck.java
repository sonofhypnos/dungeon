package informatik.model.Cards;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.player.PlayerAbilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Player-deck is used for drawing abilities for the user.
 *
 * @author upkim
 * @version 1.0.0 2022-03-10
 */
public class PlayerDeck extends CardDeck<Ability<Player, Monster>> {


    /**
     * Instantiates a new Card deck.
     */
    public PlayerDeck() {
        super(new ArrayList<>(
                Arrays.stream(PlayerAbilities.values()).map(PlayerAbilities::getAbility).collect(Collectors.toList())));
    }
}
