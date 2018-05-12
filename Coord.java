
/**
 * An utility coordinate class. A coordinate is composed of two int part.
 */
public class Coord {

    private static String minCoordString = "A1";
    private static String maxCoordString = "J10";
    private static Coord minCoord = new Coord(getCoord1FromString(minCoordString), getCoord2FromString(minCoordString));
    private static Coord maxCoord = new Coord(getCoord1FromString(maxCoordString), getCoord2FromString(maxCoordString));

    /**
     * @return The first coordinate of the game as a Coord object
     */
    static public Coord getMinCoord() {
        return minCoord;
    }

    /**
     * @return The last coordinate of the game as a Coord object
     */
    static public Coord getMaxCoord() {
        return maxCoord;
    }

    private int coord1; // The letter part
    private int coord2; // The number part
    private boolean hit = false;

    /**
     * @param coord The string coordinate to convert to the object
     * @throws CoordException Coordinate exception describing the error
     */
    public Coord(String coord) throws CoordException {
        int length = coord.length();
        // Check that the coord length is valid
        if (length < minCoordString.length() || length > maxCoordString.length()) {
            throw new CoordExceptionInvalidLength(coord);
        }

        try {
            // Try to get the two components of the coordinate
            coord1 = getCoord1FromString(coord);
            coord2 = getCoord2FromString(coord);
        } catch (Exception e) {
            throw new CoordExceptionInvalidType(coord);
        }

        // Check if the coordinate is in the grid define by the max and min coord
        if (coord1 < getMinCoord().coord1 || coord2 < getMinCoord().coord2 ||
            coord1 > getMaxCoord().coord1 || coord2 > getMaxCoord().coord2) {
            throw new CoordExceptionInvalidRange(coord);
        }
    }

    /**
     * This constructor doesn't do any check
     * @param coord1 The first part of coordinate as an int
     * @param coord2 The second part of the coordinate as an int
     */
    public Coord(int coord1, int coord2) {
        this.coord1 = coord1;
        this.coord2 = coord2;
    }

    /**
     * Get the first part of a String coordinate as an int
     * @param coord The coordinate to decompose
     */
    private static int getCoord1FromString(String coord) {
        return (int) coord.toUpperCase().charAt(0);
    }

    /**
     * Get the second part of a String coordinate as an int
     * @param coord The coordinate to decompose
     */
    private static int getCoord2FromString(String coord) {
        String secondPart = coord.substring(1);
        return Integer.parseInt(secondPart); 
    }

    /**
     * @return The first part of the coordinate as an int
     */
    public int getCoord1() {
        return coord1;
    }

    /**
     * @return The second part of the coordinate as an int
     */
    public int getCoord2() {
        return coord2;
    }

    /**
     * Set the hit flag of the coordinate. Used to know where people fired
     */
    public void setHit() {
        hit = true;
    }

    /**
     * @return a boolean set to true if this coordinate was hit, else it returns fals
     */
    public boolean isHit() {
        return hit;
    }

    /**
     * @param obj The object to test the equality with
     * @return a boolean indicating if the two objects are equals or not
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Coord other = (Coord) obj;
        return getCoord1() == other.getCoord1() && getCoord2() == other.getCoord2();
    }

    /**
     * @return the coordinate as a String
     */
    public String toString() {
        return ((char)getCoord1()) + Integer.toString(getCoord2());
    }
}