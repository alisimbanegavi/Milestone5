package GameModel.Tiles;

import GameModel.Coordinate;

public class BasicTile implements Tile {
    Coordinate coord;
    boolean traversable;

    public BasicTile(int xCoord, int yCoord, boolean traverse){
        setCoord(new Coordinate(xCoord, yCoord));
        traversable = traverse;
    }

    public void setCoord(Coordinate location) {
        coord = location;
    }

    public Coordinate getCoord() {return coord;}

    public boolean canTraverse(){
        return traversable;
    }
}
