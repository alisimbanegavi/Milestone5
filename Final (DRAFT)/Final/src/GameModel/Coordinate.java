package GameModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public static List<Coordinate> cornerCoordinates(int dimensions) {
        // Generating list of corner coordinates
        List<Coordinate> corners = new ArrayList<>();
        corners.add(new Coordinate(0, 0)); // Northwest corner
        corners.add(new Coordinate(0, dimensions - 1)); // Northeast corner
        corners.add(new Coordinate(dimensions - 1, 0)); // Southest corner
        corners.add(new Coordinate(dimensions - 1, dimensions - 1)); // Southwest corner

        return corners;
    }

    public static List<Coordinate> centerCoordinates(int dimensions) {
        List<Coordinate> center = new ArrayList<>();
        center.add(new Coordinate((dimensions / 2) - 1, (dimensions / 2) - 1)); // Northwest center corner
        center.add(new Coordinate((dimensions / 2) - 1, (dimensions / 2))); // Northeast center corner
        center.add(new Coordinate((dimensions / 2), ((dimensions / 2) - 1))); // Southeast center corner
        center.add(new Coordinate((dimensions / 2), (dimensions / 2))); // Southwest center corner

        return center;
    }
}