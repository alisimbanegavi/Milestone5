package Model;

import java.util.HashMap;
/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */
public class Coordinate {
    private int xPos;
    private int yPos;

    public Coordinate(int x, int y) {
        setX(x);
        setY(y);
    }

    public void setX(int x) {
        xPos = x;
    }

    public void setY(int y) {
        yPos = y;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    /**
     * Method to calculate all adjacent neighbour positions for current coordinate
     *
     * @return HashMap<></> List of all adjacent coordinates
     */
    public HashMap<Direction, Coordinate> getAdjacent() {
        HashMap<Direction, Coordinate> adjMap = new HashMap<>();
        adjMap.put(Direction.NORTH, new Coordinate(xPos, yPos - 1));
        adjMap.put(Direction.SOUTH, new Coordinate(xPos, yPos + 1));
        adjMap.put(Direction.EAST, new Coordinate(xPos + 1, yPos));
        adjMap.put(Direction.WEST, new Coordinate(xPos - 1, yPos));

        return adjMap;
    }

    public Coordinate getNeighbour(Direction di) {
        return getAdjacent().get(di);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Coordinate)) return false;

        Coordinate tmp = (Coordinate) other;
        return this.xPos == tmp.xPos && this.yPos == tmp.yPos;
    }

    public boolean outBounds(int MAX) {
        return xPos < 0 || xPos >= MAX || yPos < 0 || yPos >= MAX;
    }
}