package Model;
/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */
public class Jewel extends Tile { // Class for Jewel objects
    Colour col;

    public Jewel(Coordinate c, Colour co) {
        super(c);
        col = co;
    }

    public Colour getColour() {
        return col;
    }

    public boolean compareJewel(Jewel j) {
        return ((j.getCoord() == this.getCoord()) && (j.getColour() == this.getColour()));
    }
}