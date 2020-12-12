package Model;

/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */
public class Action {
    private final Turtle player;
    private final Card instruction;
    private final Board gBoard;
    private final boolean bugCard;

    public Action(Turtle t, Card input, Board bGame) {
        player = t;
        instruction = input;
        gBoard = bGame;
        bugCard = (input == Card.BUG);
    }

    /**
     * Retrieves Turtle object of player currently executing action
     *
     * @return Turtle Current player
     */
    public Turtle getCurrPlayer() {
        return player;
    }

    /**
     * Retrieves Card with instruction of player currently executing action
     *
     * @return Card Current instruction
     */
    public Card getCard() {
        return instruction;
    }

    /**
     * Executes move requested by player if possible
     */
    public void action() {
        if (bugCard) { // BUG CARD
            bug();
            return;
        }// Bug card executes and method stops

        if(!player.addToCardSeq(instruction)){
            return;
        }

        // Card will be added to sequence of player's executed cards if not bug
        if (instruction.isTurn()) {
            turnLR(instruction);
        } // LEFT OR RIGHT TURN
        else {
            forward();
        } // FORWARD STEP
    }

    public void forward() {
        Coordinate currCoord = player.getCoord(); // Getting current coordinate of player
        Direction currDir = player.getDir(); // Getting current direction player is facing
        Coordinate shift = currCoord.getNeighbour(currDir); // Calculating destination point ahead of player
        gBoard.moveTurtle(player, shift);
    }

    /**
     * Turns Turtle to new direction after turning left or right
     *
     * @param side Card Indicates if left or right turn is desired
     */
    public void turnLR(Card side) {
        Direction newDir = player.getDir().turnDir(side.toString()); // Getting new Direction player will face
        player.setDir(newDir); // Setting new direction after turn
    }

    /**
     * Undoes move performed by last card used by Turtle
     */
    public void bug() {
        Card buggy = player.removeFromSeq(); // Last card executed
        if (buggy == null) {
            return;
        } // Reversal only executed if previous card sequence is not empty
        else if (buggy.isTurn()) {
            turnLR(buggy.opposite());
            return;
        } // Turn in opposite direction if last card was right or left
        // Go back in reverse direction if last card was forward step
            Direction facing = player.getDir(); // Player's current direction
            player.setDir(facing.reverse()); // Reversing player movement
            forward();
            player.setDir(facing); // Facing back to correct direction
    }

    public boolean isBug() {
        return bugCard;
    }

    /**
     * Checks if move is valid based on index of turtle's position on board and direction of turtle as specified in the Action
     *
     * @return boolean True if
     */
    public boolean validate() {
        if (getCard() == null) {
            return false;
        } // Move is automatically invalid if null
        Card shift = getCard(); // Checking move

        if(player.checkDeck(shift) == 0){
            return false; // Automatically invalid if deck doesn't have enough of card (for now)
        }

        // BUG CARD---------------------------------
        if (isBug()) {
            return validBug();
        } // Check for valid bug if bug card is inputted

        // LEFT / RIGHT---------------------------------
        if (shift.isTurn()) {
            return true;
        }
        // Move is automatically valid if move is a left turn or right turn

        // FORWARD---------------------------------------
        Coordinate currCord = player.getCoord(); // Getting player's current coordinate
        Coordinate test = currCord.getNeighbour(player.getDir()); // Calculating coordinate in front of player if they would like to step forward

        return ((!test.outBounds(gBoard.getSize())) && (gBoard.isClear(test) || (gBoard.checkForJewel(test))));
        // Valid move if new coordinate is in bounds AND space is empty or is jewel
    }

    /**
     * Checks if bug card request to undo last turn is valid for a player based on their location and past actions
     *
     * @return boolean True if bug card can be used to undo action
     */
    public boolean validBug() {
        // Method to test if bug card move is valid based on index of turtle's position on board and direction of turtle
        if (!isBug()) {
            return false;
        } // False if bug card is not being evaluated

        Coordinate currCoord = player.getCoord(); // Player's current coordinate

        if (player.cardSeq().size() == 0) {
            return false;
        } // Invalid bug card if player hasn't played yet
        if (!player.cardSeq().peek().isTurn()) // Test if bug card is requesting to undo forward step and NOT left/right turn
        {
            Direction bugDir = player.getDir().reverse(); // Getting reverse of current player's direction
            Coordinate test = currCoord.getNeighbour(bugDir); // Testing coordinate behind bug
            return (gBoard.isClear(test)); // True if coordinate is empty
        }
        return true; // Automatically true if bug card is reversing right or left turn
    }
}
