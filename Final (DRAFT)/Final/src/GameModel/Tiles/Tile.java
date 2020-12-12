package GameModel.Tiles;

import GameModel.Coordinate;

public interface Tile{
    public void setCoord(Coordinate location);

    Coordinate getCoord();

    public boolean canTraverse();
}