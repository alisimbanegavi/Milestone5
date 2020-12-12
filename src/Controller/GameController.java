/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */
package Controller;

import Model.Card;
import Model.GamePlay;
import Model.GameModel;
import Model.Turtle;
import View.GameView;

public class GameController {
    private GameModel model;
    private final GamePlay gamePlay;

    /**
     * Constructor for controller
     */
    public GameController() {
        gamePlay = new GamePlay(this);
    }

    /**
     * Begins game by calling new initializer object. First step of gameplay before players can execute moves
     *
     * @return boolean Returns true if game is successfully initialized
     */
    public boolean initializeGame() {
        int nPlayers = GameView.menu();
        if (nPlayers == 0) return false;
        else {
            GameInitializer.start(nPlayers);
            model = GameInitializer.newGame();
            return true;
        }
    }

    /**
     * Method to play a full game by executing as many rounds as necessary until all players have won
     */
    public void playGame() {
        gamePlay.start(model);
        GameView.displayText("Congratulations everyone has won!\n\n-----------------------"); // Game has ended and display message is shown
    }

    public void updateBoard() {
        if (model != null) {
            GameView.displayBoard(BoardConverter.parseJewels(model.jewels()), BoardConverter.parseTurtles(model.turtles()), model.getMaxSize()); // Displaying board configuration in view
        }
    }

    public void updateTurtle(Turtle player) {
        GameView.displayText(player.getPlayerName() + " (PLAYER " + (player.getColour().ordinal() + 1) + ") - YOUR " + player.getColour().toString() + " TURTLE IS NOW FACING " + player.getDir().toString() + ".\n");
    }

    public void playerWon(Turtle player) {
        GameView.displayText("CONGRATULATIONS, " + player.getPlayerName() + " (PLAYER  " + (player.getColour().ordinal() + 1) +
                ")! \nYOUR " + player.getColour().toString() + " TURTLE HAS CAPTURED A JEWEL. YOU HAVE WON!!!");
    }

    public void newRound() {
        GameView.displayText("- - - - - - NEW ROUND BEGINNING | PREPARE YOUR STRATEGY - - - - - -\n");
    }

    public Card getMove(Turtle player) {
        // Prompting player for move by requesting input
        StringBuilder sb = new StringBuilder(); // Building string for prompt
        sb.append("[LEFT (" + player.getDir().turnDir("LEFT").toString() + ")"); // Direction player will turn in left is chosen
        sb.append(", RIGHT (" + player.getDir().turnDir("RIGHT").toString() + ")"); // Direction if right is chosen
        sb.append(", FORWARD (" + player.getDir().toString() + ")"); // Direction if forward step is chosen
        sb.append(", BUG]: ");

        String response = GameView.promptMove(player.getPlayerName() + " (PLAYER " + (player.getColour().ordinal() + 1) + ") - ENTER ACTION..............", sb.toString());
        Card choice = (model.moveList().contains(response)) ? Card.valueOf(response) : null; // Getting corresponding Card for requested move
        return choice;
    }

    public void invalidMove(Turtle player) {
        GameView.displayText("SORRY, " + player.getPlayerName() + " (PLAYER " + (player.getColour().ordinal() + 1) + "), THAT MOVE IS INVALID.");
    }
}
