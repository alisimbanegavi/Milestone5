package GameModel.Tiles;

import GameModel.Direction;
import GameModel.Coordinate;

public class MoveableTile extends TileDecorator {
    public MoveableTile(Tile ti) {
        super(ti);
    }

    public void move(Direction dir){
        Coordinate shift = super.getCoord().getNeighbour(dir);
        super.setCoord(shift);
    }
}
