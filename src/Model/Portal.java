package Model;
/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */
public class Portal extends Tile{
    Coordinate partner;

    public Portal(Coordinate c, Coordinate other) {
        super(c);
        partner = other;
    }

    public Coordinate getPartnerCoord(){
        return partner;
    }
}