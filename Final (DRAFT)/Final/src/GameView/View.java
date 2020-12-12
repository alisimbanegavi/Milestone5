package GameView;

import GameController.Controller;
import GameController.Observer;

import java.util.Scanner;

public class View extends Observer {
    private static View view = new View();
    private static Scanner scan;
    private View(){
        view.scan = new Scanner(System.in);
    }

    public static View getView(){return view;}

    public String readInput(){return scan.next();}

    public void output(String text){
        System.out.println(text); // Prints out line of text
    }

    public void prompt(String promptText){
        System.out.print(promptText); // Prints out inline text
    }

    public void update() {}
}