import GameModel.Model;
import GameView.View;

public class Main {
    public static void main(String[] args){
        View view = View.getView();

    }

    public static Model initializeGame(){
        String menu = new String(
                "- - - - - - - - - - WELCOME to ROBOT TURTLES - - - - - - - - - - \n" +
                        "GAME MENU:\n1) PLAY GAME\n2) EXIT\n\nENTER CHOICE: "
        );
    }
}
