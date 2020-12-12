package GameModel;

public enum Card {
    LEFT,
    RIGHT,
    FORWARD,
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
}
