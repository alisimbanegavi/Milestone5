package Model;
/**
 * @author Ali Simbanegavi
 * @version C3721.5.0
 * @since 2020-12-12
 */
public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public Direction reverse() {
        // Helper method for bugStep() to reverse direction movement of player movement
        if ((this == Direction.SOUTH) || (this == Direction.NORTH)) {
            return (this == Direction.SOUTH) ? Direction.NORTH : Direction.SOUTH; // Returns south if facing north & vice versa
        }
        return (this == Direction.EAST) ? Direction.WEST : Direction.EAST; // Returns east if facing west & vice versa
    }

    public Direction turnDir(String side) {
        // Assigning each direction a numerical value that will change based on turn direction
        int n = this.ordinal(); // Getting number that corresponds to current direction
        n = (side.toUpperCase().equals("LEFT")) ? ((n - 1) + 4) % 4 : ((n + 1) + 4) % 4;
        // Decrement value by 1 if left turn, increment by 1 if right turn - mod 4 calculation added for wraparound from north to west via left turn
        return Direction.values()[n];
    }
}