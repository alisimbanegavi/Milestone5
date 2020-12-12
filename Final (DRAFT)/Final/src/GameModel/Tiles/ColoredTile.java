package GameModel.Tiles;

import java.awt.*;

public class ColoredTile extends TileDecorator {
    Color color;

    public ColoredTile(Tile ti) {
        super(ti);
    }

    public void setColor(Color set){color = set;}

    public Color getColor(){return color;}
}
