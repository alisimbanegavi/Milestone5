package GameModel.Tiles;

import GameModel.Coordinate;

public class TileFactory {
    public Tile produce(String type, Coordinate coord){
        int x = coord.getX();
        int y = coord.getY();

        if(type.equals("PLAYER")){
            return new MoveableTile(new ColoredTile(new BasicTile(x, y, false)));
        }
        else if(type.equals("JEWEL")){
            return new ColoredTile(new BasicTile(x, y, true));
        }
        else if(type.equals("CRATE")){
            return new MoveableTile(new BasicTile(x, y, false));
        }
        else if(type.equals("WALL") || type.equals("ICE")){
            return new BasicTile(x, y, false);
        }
        return new BasicTile(x, y, true); // STANDARD TILE, PUDDLE, AND PORTAL WILL BE CREATED BY THESE
    }
}
