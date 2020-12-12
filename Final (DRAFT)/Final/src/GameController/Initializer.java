package GameController;

import GameModel.*;
import GameModel.Tiles.ColoredTile;
import GameModel.Tiles.Tile;
import GameModel.Tiles.TileDecorator;
import GameModel.Tiles.TileFactory;
import GameView.View;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/**
 * @author Ali Simbanegavi + Daniel Cumming
 * @version C3721.2.0
 * @since 2020-11-09
 * <p>
 * Class to initialize game by assigning players and populating board
 */
public class Initializer {
    private static final int SIZE = 8;
    private static int nPlayers;
    private static View mainView;
    private static TileFactory tiler;

    public Initializer(View newView){
        mainView = newView;
        tiler = new TileFactory();
    }

    public static void start(int numPlayers) {
        if ((numPlayers < 1) || (numPlayers > 4)) { // Condition if number of players inputted is not between 1-4
            mainView.output((numPlayers < 1) ? "\nNOT ENOUGH PLAYERS!" : "\nTOO MANY PLAYERS!");
            mainView.prompt("PLEASE RE-ENTER NUMBER OF PLAYERS [1-4]:");
            try {
                start(Integer.parseInt(mainView.readInput())); // Recursively calling method to try again
            }catch(InputMismatchException in){
                mainView.prompt("PLEASE ENTER *NUMERICAL* NUMBER OF PLAYERS [1-4]:");
                start(Integer.parseInt(mainView.readInput()));
            }
        } else {
            nPlayers = numPlayers;
        }
    }

    public static Model newGame() {
        /*
        1. Create player tiles and assign coordinates
        2. Create jewel tiles
        3. Create walls & ice walls
        4. Create crates
        5. Populate Model with logic of all created pieces
         */
        return null;
    }

    public static List<Player> createPlayers() {
        // Creates list of n players and assigns each player's piece to a corner coordinate
        List<Coordinate> locations = Coordinate.cornerCoordinates(SIZE);
        List<Player> playerList = new ArrayList<>();
        Tile turtle;
        Player newPlayer;
        String newName;

        // Assigning each player to a new Turtle and adding to list of players
        for (int i = 0; i < nPlayers; i++) {
            // Gathering player info through system input and initializing Turtles
            mainView.prompt("ENTER PLAYER " + (i + 1) + "'S NAME: ");
            newName = mainView.readInput();
            turtle = tiler.produce("PLAYER", locations.get(i));
            // turtle.setColour(); NOT WORKING! Issue with inheritance
            newPlayer = new Player(newName, turtle);
            newPlayer.setDir((locations.get(i).getY() == 0 ? Direction.SOUTH : Direction.NORTH));
            playerList.add(newPlayer);
        }
        return playerList;
    }
}