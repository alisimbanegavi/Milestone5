/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */

package Controller;

import Model.Coordinate;
import Model.Tile;
import Model.Turtle;

import java.util.List;

/**
 * Class for parsing board configuration to game view. This class allows for the configuration of the Board, which is contained
 * in the model, to be passed onto the view without contaminating the view by having it access the model directly.
 */
public class BoardConverter {

    public static int[][] parseJewels(List<Tile> jewels) {
        int[][] results = new int[jewels.size()][3];
        for (int i = 0; i < jewels.size(); i++) {
            Coordinate coord = jewels.get(i).getCoord();
            results[i][0] = coord.getX();
            results[i][1] = coord.getY();
            results[i][2] = jewels.get(i).getColour().ordinal();
        }
        return results;
    }

    public static int[][] parseTurtles(List<Turtle> turtles) {
        int[][] results = new int[turtles.size()][4];
        for (int i = 0; i < turtles.size(); i++) {
            Coordinate coord = turtles.get(i).getCoord();
            results[i][0] = coord.getX();
            results[i][1] = coord.getY();
            results[i][2] = turtles.get(i).getColour().ordinal();
            results[i][3] = turtles.get(i).getDir().ordinal();
        }
        return results;
    }

}