package GameModel;

import GameModel.Tiles.Tile;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Player {
    private Tile turtle;
    private String name;
    private HashMap<String, Integer> deck;
    private Stack<Card> used;
    private boolean winner;
    private Direction dir;

    public Player(String name, Tile piece){
        turtle = piece;
        this.name = name;

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

    public String getPlayerName() {
        return name;
    }

    public void setDir(Direction new_dir) {dir = new_dir;}

    public Direction getDir() {
        return dir;
    }

    public Tile getTurtle(){return turtle;}

    public Stack<Card> cardSeq() {
        // Returns sequence of cards executed by player
        return used;
    }

    public int checkDeck(Card card){
        return deck.get(card.toString());
    }

    public boolean playCard(Card toPlay) {
        String instruction = toPlay.toString();
        if(deck.get(instruction) == 0){
            //GameView.displayText("OH NO, " + name + " - YOU ARE OUT OF " + instruction + " CARDS!");
            return false;
        }
        deck.replace(instruction, deck.get(instruction) - 1); // Decrementing number of cards in deck and adding move to card sequence
        used.push(toPlay);
        return true;
    }

    public boolean winner() {
        return winner;
    }

    public void win() { winner = true;}
}