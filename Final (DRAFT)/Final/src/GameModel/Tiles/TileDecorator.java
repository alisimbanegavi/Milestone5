package GameModel.Tiles;

import GameModel.Coordinate;

public class TileDecorator implements Tile {
    protected Tile tile;

    public TileDecorator(Tile ti){
        tile = ti;
    }

    public void setCoord(Coordinate co){
        tile.setCoord(co);
    }

    public Coordinate getCoord() {
        return tile.getCoord();
    }

    public boolean canTraverse() {return tile.canTraverse();}
}