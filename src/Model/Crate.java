package Model;
/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */
public class Crate implements Piece{
    Coordinate coord;

    public Crate(Coordinate c) {
        setCoord(c);
    }

    public void move(Direction dir){
        this.setCoord(this.getCoord().getNeighbour(dir));
    }

    @Override
    public void setCoord(Coordinate co) {
        coord = co;
    }

    @Override
    public Coordinate getCoord() {
        return coord;
    }
}
