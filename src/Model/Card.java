package Model;

import java.util.Stack;
/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */
public enum Card {
    LEFT,
    RIGHT,
    FORWARD,
    LASER,
    BUG;

    /**
     * Simple method to test if current card is left or right
     *
     * @return boolean True if left or right Card
     */
    public boolean isTurn() {
        return (this.equals(LEFT) || this.equals(RIGHT));
    }

    /**
     * Returns opposite direction if this is a right or left
     *
     * @return Card Opposite of left or right
     */
    public Card opposite() {
        if (!isTurn()) {
            return null;
        } // Returns null if not a left or right card
        return (this.equals(Card.LEFT) ? Card.RIGHT : Card.LEFT);
    }

    public Stack<Card> getThree(Card first, Card second, Card third){
        Stack<Card> moves = new Stack<>();
        moves.push(first);
        moves.push(second);
        moves.push(third);
        return moves;
    }
}