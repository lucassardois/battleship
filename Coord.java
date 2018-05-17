
package sardois.lucas.Coord;

/**
 * An utility coordinate class. A coordinate is composed of two int part.
 */
public class Coord {

    private static String minCoordString = "A1";
    private static String maxCoordString = "J10";
    private static Coord minCoord = new Coord(getCoordHorizontalFromString(minCoordString), getCoordVerticalFromString(minCoordString));
    private static Coord maxCoord = new Coord(getCoordHorizontalFromString(maxCoordString), getCoordVerticalFromString(maxCoordString));

    /**
     * @return The first coordinate of the game as a Coord object
     */
    public static Coord getMinCoord() {
        return minCoord;
    }

    /**
     * @return The last coordinate of the game as a Coord object
     */
    public static Coord getMaxCoord() {
        return maxCoord;
    }

    public static boolean isStringLengthValid(String coord) {
        int length = coord.length();
        if (length < minCoordString.length() || length > maxCoordString.length()) {
            return false;
        }
        return true;
    }

    /**
     * Get the horizontal part of a String coordinate as an int
     * @param coord The coordinate to decompose
     * @return return a int with the correct value of the coordinate. If the function fails it return -1
     */
    public static int getHorizontalPartFromString(String coord) {
        try {
            return (int) coord.toUpperCase().charAt(0);    
        } catch (Exception exception) {
            return -1;
        }
    }

    /**
     * Get the vertical part of a String coordinate as an int
     * @param coord The coordinate to decompose
     * @return return a int with the correct value of the coordinate. If the function fails it return -1
     */
    public static int getVerticalPartFromString(String coord) {
        try {
            String verticalPart = coord.substring(1);
            return Integer.parseInt(verticalPart);
        catch (Exception exception) {
            return -1;
        }
    }

    public static boolean isInRange(int horizontal, int vertical) {
        if (horizontal < getMinCoord().coordHorizontal || vertical < getMinCoord().coordVertical ||
            horizontal > getMaxCoord().coordHorizontal || vertical > getMaxCoord().coordVertical) {
            return false;
        }
        return true;
    }

    private int coordHorizontal;
    private int coordVertical;
    private boolean hit = false;

    /**
     * @param coordHorizontal The horizontal part of coordinate as an int
     * @param coordVertical The vertical part of the coordinate as an int
     */
    public Coord(int coordHorizontal, int coordVertical) {
        this.coordHorizontal = coordHorizontal;
        this.coordVertical = coordVertical;
    }

    /**
     * @return The horizontal part of the coordinate as an int
     */
    public int getCoordHorizontal() {
        return coordHorizontal;
    }

    /**
     * @return The vertical part of the coordinate as an int
     */
    public int getCoordVertical() {
        return coordVertical;
    }

    /**
     * Set the hit flag of the coordinate. Used to know where player fired
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
        return getCoordHorizontal() == other.getCoordHorizontal() && getCoordVertical() == other.getCoordVertical();
    }

    /**
     * @return the coordinate as a String
     */
    public String toString() {
        return ((char)getCoordHorizontal()) + Integer.toString(getCoordVertical());
    }
}
