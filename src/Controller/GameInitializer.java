package Controller;

import java.util.ArrayList;
import java.util.List;

import Model.*;
import View.GameView;

/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 * <p>
 * Class to initialize game by assigning players and populating board
 */
public class GameInitializer {
    private static final int SIZE = 8;
    private static int nPlayers;

    public static void start(int numPlayers) {
        if ((numPlayers < 1) || (numPlayers > 4)) { // Condition if number of players inputted is not between 1-4
            GameView.displayText((numPlayers < 1) ? "\nNOT ENOUGH PLAYERS!" : "\nTOO MANY PLAYERS!");
            GameView.displayPrompt("PLEASE RE-ENTER NUMBER OF PLAYERS [1-4]:");
            start(GameView.readDigit()); // Recursively calling method to try again
        } else {
            nPlayers = numPlayers;
        }
    }

    public static GameModel newGame() {
        List<Turtle> initPlayers = createPlayers();
        List<Tile> initJewels = createJewels(initPlayers);
        return new GameModel(initPlayers, initJewels);
    }

    public static List<Turtle> createPlayers() {
        // Creates list of n players and assigns each player's piece to a corner coordinate
        List<Coordinate> locations = cornerCoordinates();
        List<Turtle> playerList = new ArrayList<>();
        Direction currDir;

        // Assigning each player to a new Turtle and adding to list of players
        for (int i = 0; i < nPlayers; i++) {
            // Gathering player info through system input and initialize Turtles
            currDir = (locations.get(i).getY() == 0 ? Direction.SOUTH : Direction.NORTH);
            Turtle newPlayer = new Turtle(locations.get(i), Colour.values()[i], currDir);
            GameView.displayPrompt("ENTER PLAYER " + (i + 1) + "'S NAME: ");
            newPlayer.setPlayerName(GameView.readText()); // Prompting each player for their name and setting
            playerList.add(newPlayer);
        }
        return playerList;
    }

    public static List<Tile> createJewels(List<Turtle> players) {
        // List of jewels generated for each player with coordinates assigned to center
        List<Tile> jwls = new ArrayList<>();
        List<Coordinate> cntr = centerCoordinates();
        int count = 0;

        for (Turtle p : players) {
            jwls.add(new Jewel(cntr.get(count), p.getColour()));
            count++;
        }
        return jwls;
    }
/*
    public static List<Piece> createWalls(int numWalls, int numIce){
        List<Piece> walls = new ArrayList<>();
        int min = 1;
        int max = SIZE - 1;
        int y = 0;
        int i = 0;

        // Creating 8 walls
        while(walls.size() < 8){
            while(cornerCoordinates().contains())
            y = (int) ((Math.random() * (max - min)) + min);
            // Need to figure out where to place walls!
        }
    }

    public static List<Piece> createCrates(int numCrates){
        List<Piece> crates = new ArrayList<>();
        // Crates will be placed around
    }*/

    public static List<Coordinate> cornerCoordinates() {
        // Generating list of corner coordinates
        List<Coordinate> corners = new ArrayList<>();
        corners.add(new Coordinate(0, 0)); // Northwest corner
        corners.add(new Coordinate(0, SIZE - 1)); // Northeast corner
        corners.add(new Coordinate(SIZE - 1, 0)); // Southest corner
        corners.add(new Coordinate(SIZE - 1, SIZE - 1)); // Southwest corner

        return corners;
    }

    public static List<Coordinate> centerCoordinates() {
        List<Coordinate> center = new ArrayList<>();
        center.add(new Coordinate((SIZE / 2) - 1, (SIZE / 2) - 1)); // Northwest center corner
        center.add(new Coordinate((SIZE / 2) - 1, (SIZE / 2))); // Northeast center corner
        center.add(new Coordinate((SIZE / 2), ((SIZE / 2) - 1))); // Southeast center corner
        center.add(new Coordinate((SIZE / 2), (SIZE / 2))); // Southwest center corner

        return center;
    }
}