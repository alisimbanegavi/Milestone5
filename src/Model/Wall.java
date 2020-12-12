package Model;
/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */
public abstract class Wall implements Piece{
    private Coordinate coord;

    public Wall(Coordinate c) {
        setCoord(c);
    }

    public void setCoord(Coordinate co) {
        coord = co;
    }

    public Coordinate getCoord() {
        return coord;
    }
}
