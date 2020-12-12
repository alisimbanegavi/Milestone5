package Model;

import View.GameView;

import java.util.HashMap;
import java.util.Stack;
/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */
public class Turtle extends Tile {
    private Direction dir;
    private String name;
    private final Stack<Card> cardSequence;
    private HashMap<String, Integer> deck;
    private boolean winner;
    private Colour col;

    public Turtle(Coordinate c, Colour colour, Direction d) {
        super(c);
        col = colour;
        setDir(d);
        winner = false;
        cardSequence = new Stack<>();
        /*
        Players alloted:
        ● 18 blue Step Forward cards
        ● 8 yellow turn left cards
        ● 8 purple turn right cards
        ● 1 brown Bug card
         */
        deck = new HashMap<>();
        deck.put("FORWARD", 18);
        deck.put("LEFT", 8);
        deck.put("RIGHT", 8);
        deck.put("BUG", 1);
        //deck.put("FROG", );

    }

    public void setDir(Direction new_dir) {
        dir = new_dir;
    }

    public Direction getDir() {
        return dir;
    }

    public void setPlayerName(String n) {
        name = n;
    }

    public String getPlayerName() {
        return name;
    }

    public boolean hasWon() {
        return winner;
    }

    public void won(){winner = true;}

    public Stack<Card> cardSeq() {
        // Returns sequence of cards executed by player
        return cardSequence;
    }

    public boolean addToCardSeq(Card toAdd) {
        String instruction = toAdd.toString();
        if(deck.get(instruction) == 0){
            GameView.displayText("OH NO, " + name + " - YOU ARE OUT OF " + instruction + " CARDS!");
            return false;
        }
        deck.replace(instruction, deck.get(instruction) - 1); // Decrementing number of cards in deck and adding move to card sequence
        cardSequence.push(toAdd);
        return true;
    }

    public Card removeFromSeq() {
        // Getting last card move executed by player
        if (cardSequence.size() > 0) {
            Card removed = cardSequence.pop();
            deck.replace(removed.toString(), deck.get(removed.toString()) + 1); // Incrementing number of cards in deck by removing from card sequence
            return removed;
        }
        return null;
    }

    public int checkDeck(Card card){
        return deck.get(card.toString());
    }

    public Colour getColour() {
        return col;
    }
}