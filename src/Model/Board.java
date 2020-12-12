package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */
public class Board {
    private int size;
    private List<Turtle> turtles;
    private List<Tile> jewels;
    // Ideally should have List<Piece> which contains all turtles and jewels
    private Object[][] config;

    public Board(int n, List<Turtle> players, List<Tile> jwls) { // Constructor should be able to take List<Piece> and populate board
        size = n;
        config = new Tile[n][n];
        turtles = new ArrayList<>(players);
        jewels = new ArrayList<>(jwls);
        placeTiles(); // Collecting all players and jewels into 1 list);
    }

    public void placeTiles() {
        // Adding turtles and jewels to list of all tiles
        List<Tile> toPlace = Stream.of(turtles, jewels)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        // Setting each tile at position
        for (Tile b : toPlace) {
            setTileAtPos(b.getCoord(), b);
        }

        //Creating 4 portals at the centre of edges of board
        int pos = size / 2;
        Coordinate nor = new Coordinate(0, pos); // Northern edge
        Coordinate sou = new Coordinate(size - 1, pos); // Southern edge
        Coordinate eas = new Coordinate(pos, 0); // Eastern edge
        Coordinate wes = new Coordinate(pos, size - 1);

        Portal north = new Portal(nor, sou);
        Portal south = new Portal(sou, nor);
        Portal east = new Portal(eas, wes);
        Portal west = new Portal(wes, eas);

        setTileAtPos(nor, north);
        setTileAtPos(sou, south);
        setTileAtPos(eas, east);
        setTileAtPos(wes, west);
    }

    /**
     * Returns tile at coordinate specified
     *
     * @param target Target coordinate
     * @return Tile A tile or null if coordinate is unoccupied
     */
    public Tile getTileAtPos(Coordinate target) {
        // Returns tile at specific coordinate
        return (Tile) config[target.getX()][target.getY()];
    }

    /**
     * Setting tile at particular coordinate on board
     *
     * @param target  Location where tile will be placed
     * @param toPlace Tile to put on coordinate
     */
    public void setTileAtPos(Coordinate target, Tile toPlace) {
        if ((toPlace != null) && (!toPlace.getCoord().equals(target))) {// Changing coordinate of tile if it doesn't match with new position
            toPlace.setCoord(target);
        }

        config[target.getX()][target.getY()] = toPlace; // Saving to list of occupiedTiles coordinates
    }

    /**
     * Tests if coordinate is empty by checking array of tiles
     *
     * @param c Coordinate to check
     * @return boolean True if Coordinate is empty
     */
    public boolean isClear(Coordinate c) {
        return (getTileAtPos(c) == null);
    }

    public void clear(Coordinate c) {
        config[c.getX()][c.getY()] = null;
    }

    /**
     * Moves a player's turtle while simultaeneously checking for Jewel. Turtle moves if no jewel is present or is marked winner and picks up jewels
     *
     * @param toMove Turtle to be moved
     * @param dest   New coordinate where Turtle will move
     */
    public void moveTurtle(Turtle toMove, Coordinate dest) {
        Coordinate orig = toMove.getCoord();
        // Board checking if player Turtle is about to be moved onto jewel
        if (checkForJewel(dest)) {
            pickJewel(toMove, (Jewel) getTileAtPos(dest));
        } // Mark player as winner if they are about to pick up jewel
        else if(getTileAtPos(dest) instanceof Portal){ // Checking if player is about to move onto portal
            Portal temp = (Portal) getTileAtPos(dest);
            if (isClear(temp.getPartnerCoord())){
                setTileAtPos(temp.getPartnerCoord(), toMove);
                clear(orig);
            }
        }
        else {
            setTileAtPos(dest, toMove);
            clear(orig);
        } // Moving player to new tile if no jewel is found
    }

    public void pickJewel(Turtle winner, Jewel toPick) {
        winner.won(); // Setting player as winner
        turtles.remove(winner);
        clear(winner.getCoord()); // Removing Turtle tile
        jewels.remove(toPick);
        clear(toPick.getCoord()); // Removing Jewel tile
    }

    public boolean checkForJewel(Coordinate target) {
        return (getTileAtPos(target) instanceof Jewel);
    }
    // Helper method to check if coordinate is Jewel

    public List<Turtle> getTurtles() {
        return turtles;
    } // Returns list of turtle tiles

    public List<Tile> getJewels() {
        return jewels;
    }

    public int getSize() {
        return size;
    }
}