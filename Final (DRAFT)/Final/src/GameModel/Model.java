package GameModel;

import GameController.Controller;
import GameController.Observer;

public class Model extends Observer {
    Board board;
    Controller control;

    public Model(Controller con, Board setup){
        control = con;
        control.attach(this);
        board = setup;
    }

    public boolean isValid(Action act){return false;}

    public void update() {}
}
