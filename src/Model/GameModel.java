package Model;

import java.util.ArrayDeque;
import java.util.List;

/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */public class GameModel {
    private static final int MAX_SIZE = 8;
    private ArrayDeque<Turtle> players;
    private Board board;
    private boolean complete;

    public GameModel(List<Turtle> tMasters, List<Tile> jwls) {
        board = new Board(MAX_SIZE, tMasters, jwls);
        players = new ArrayDeque<>(tMasters);
        complete = false;
    }

    public List<Turtle> turtles() {
        return board.getTurtles();
    } // Returns list of turtle tiles on board

    public List<Tile> jewels() {
        return board.getJewels();
    } // Returns list of jewel tiles on board

    public boolean gameOver() {
        return complete;
    } //  Checking if game is over

    public ArrayDeque<Turtle> players() {
        return players;
    } // Returns queue of players

    public Board getBoard() {
        return board;
    } // Returns game board

    public void update(Action chg) { // Update details in model after move is executed
        chg.action();
        // Resetting current queue of players in case any players have won and left game after a round
        if (chg.getCurrPlayer().hasWon()) {
            players = new ArrayDeque<>(turtles());
        }
        if (players.size() == 0) {
            complete = true;
        } // Mark game complete if all players have collected their jewels and board is empty
    } // Updates board if valid move is executed while keeping track of whether or not game is over

    public List<String> moveList() {
        return List.of("LEFT", "RIGHT", "FORWARD", "BUG");
    }
    // Helper method to return card instructions as strings; will help with parsing user input in GameController.promptMove()

    public int getMaxSize() {
        return MAX_SIZE;
    } // Returns maximum size of board according to model
}