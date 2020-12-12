package Model;
/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */
public abstract class Tile implements Piece{
    private Coordinate coord;

    public Tile(Coordinate c) {
        setCoord(c);
    }

    public void setCoord(Coordinate co) {
        coord = co;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public Colour getColour() {
        return null;
    }
}