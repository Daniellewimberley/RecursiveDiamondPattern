public class RecursiveDiamond {

    public static void main(String[] args) {
        int totalStars = 25;     // width of the diamond
        printLine(totalStars);   // top row
        printUpper(11, 1);       // 11 rows shrinking inward
        printLower(1, 11);       // 11 rows expanding outward
        printLine(totalStars);   // bottom row
    }

    // Prints a full line of stars
    public static void printLine(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    /**
     * Recursive method for the UPPER half of the diamond.
     * left = number of stars on the left side
     * gap = number of spaces in the middle before printing right side stars
     *
     * Base Case: when left reaches 0, stop.
     * Recursive Step: shrink the outside stars and expand the middle gap.
     */
    public static void printUpper(int left, int gap) {
        if (left == 0) return;

        // left stars
        for (int i = 0; i < left; i++) System.out.print("*");

        // middle spaces
        for (int i = 0; i < gap; i++) System.out.print(" ");

        // right stars
        for (int i = 0; i < left; i++) System.out.print("*");

        System.out.println();

        // recursive call (shrink stars, expand gap by 2 each row)
        printUpper(left - 1, gap + 2);
    }

    /**
     * Recursive method for the LOWER half of the diamond.
     * This simply reverses the process of the upper half.
     */
    public static void printLower(int left, int gap) {
        if (left > 11) return;

        for (int i = 0; i < left; i++) System.out.print("*");

        for (int i = 0; i < (gap * 2 - 1); i++) System.out.print(" ");

        for (int i = 0; i < left; i++) System.out.print("*");

        System.out.println();

        printLower(left + 1, gap - 1);
    }
}
