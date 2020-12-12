package Model;
/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */
public class Ice extends Wall{
    boolean melted;

    public Ice(Coordinate co){
        super(co);
        melted = false;
    }

    public void melt(){
        melted = true;
    }

    public boolean isPuddle(){return melted;}
}
