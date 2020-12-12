package View;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */
public class GameView {
    private static final Scanner input = new Scanner(System.in);

    public static int menu() {
        displayPrompt(
                "- - - - - - - - - - WELCOME to ROBOT TURTLES - - - - - - - - - - \n" +
                        "GAME MENU:\n1) PLAY GAME\n2) EXIT\n\nENTER CHOICE[1, 2]: "
        );
        if (readDigit() == 1) {
            int nPlayers = 0;
            displayText("");
            while (nPlayers < 1 || nPlayers > 4) {
                displayPrompt("ENTER NUMBER OF PLAYERS [1-4]: ");
                nPlayers = readDigit();
            }
            return nPlayers;
        }
        displayText("GOODBYE!");
        return 0;
    }

    public static String promptMove(String playerInfo, String choices) {
        displayText(playerInfo);
        displayPrompt(choices);
        return readText().toUpperCase();
    }

    /**
     * Displays line of text in console
     *
     * @param txt Text to displayer
     */
    public static void displayText(String txt) {
        System.out.println(txt);
    }

    /**
     * Displays text prompt in console for requesting player input in same line
     *
     * @param prompt Text of prompt to display
     */
    public static void displayPrompt(String prompt) {
        System.out.print(prompt);
    }

    /**
     * Displays board configuration in console
     *
     * @param jewels  Jewels on board
     * @param players Players on board
     * @param size    Board sizemaven
     */
    public static void displayBoard(int[][] jewels, int[][] players, int size) {
        System.out.println();
        char[][] board = new char[size][size];
        for (int y = 0; y < size; y++)
            for (int x = 0; x < size; x++)
                board[y][x] = '.';

        for (int i = 0; i < jewels.length; i++) {
            int x = jewels[i][0];
            int y = jewels[i][1];
            board[y][x] = 'j';
        }

        for (int i = 0; i < players.length; i++) {
            int x = players[i][0];
            int y = players[i][1];
            // player num
            int playerNum = players[i][2] + 1; // based on colour
            board[y][x] = (char) (playerNum + '0');
        }

        StringBuilder str = new StringBuilder();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                str.append(board[y][x]);
                str.append(' ');
            }
            str.append('\n');
        }

        str.append('\n');
        System.out.println(str.toString());
    }

    /**
     * Reads text input from command line
     *
     * @return String Input from command line
     */
    public static String readText() {
        return input.next();
    }

    /**
     * Reads numeric input from command line
     *
     * @return int Number input from command line
     */
    public static int readDigit() {
        int dig = 0;

        try{dig = input.nextInt();}
        catch(InputMismatchException in){
            displayPrompt("A NUMERICAL INPUT IS NEEDED HERE. PLEASE START OVER WHEN YOU ARE ABLE TO READ INSTRUCTIONS!");
            System.exit(0);
        }
        return dig;
    }
}