import Controller.GameController;

/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */
public class TestGame {
    public static void main(String[] args) {
        GameController control = new GameController();
        if (control.initializeGame()) control.playGame();
    }
}
