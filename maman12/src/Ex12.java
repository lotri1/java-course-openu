import static java.lang.System.out;

public class Ex12 {
    //  Question 1.a
    //  ------------
    //      1. Not correct
    //      2. Not correct
    //      3. Correct
    //      4. Not correct
    //      5. Correct
    //      6. Correct

    //  Question 1.b
    //  ------------

    /**
     * Checks if a value exists in a matrix that corresponds to the what function.
     * Time complexity: O(n)
     * Memory complexity: O(1)
     */
    public static boolean findValWhat(int[][] m, int val) {
        int n = m.length;
        int row = n - 1; //last row
        int column = 0; //first column

        // Go over the matrix from the bottom left cell to the top right cell.
        // In each cycle of the loop - decrease the row or increase the column.
        // In the worst case (the value doesn't exist or the value is in the top right cell), there will be 2n cycles.
        while (row >= 0 && column < n) {
            if (m[row][column] == val) // if this cell contains the value - return true.
                return true;

            // If the current cell is bigger - decrease the row. Lower row means lower values.
            if (m[row][column] > val)
                --row;
            else // If the current cell is lower - increase the column. Higher column means higher values.
                ++column;
        }

        // Value wasn't found in the loop
        return false;
    }

    /**
     * Check if a value exists in a matrix that corresponds to the test function.
     * Time complexity: O(n)
     * Memory complexity: O(1)
     */
    public static boolean findValTest(int[][] m, int val) {
        int n = m.length;
        int row = 0;

        // Go over the first cell of the rows until finding a cell bigger than the value we are looking for.
        // This operation is performed n times at most.
        while (row < n && m[row][0] < val) {
            row++;
        }

        // Go over 2 rows - the one that we found and one before it.
        // The value should be found only in these 2 rows according to the matrix structure - each row contains values
        // lower or equal to all of the cells in the next row.
        // This loop is performed n times at most.
        for (int col = 0; col < n; col++) {
            // If the value was found in one of the 2 rows - return true.
            if ((row > 0 && m[row - 1][col] == val) || (row < n && m[row][col] == val))
                return true;
        }

        // Value wasn't found
        return false;
    }

    //  -----------------------------------------------------

    //  Question 2.a
    //  ------------

    /**
     * Counts the number of substrings that starts and ends with a specific character,
     * and contains this character one time only.
     * Time complexity: O(n)
     * Memory complexity: O(1)
     */
    public static int subStrC(String s, char c) {
        // Count the number occurrences of c in s. This operation is O(n).
        int cCounter = countCharInString(s, c);

        // A substring that we look for must contain at lease 3 c characters.
        // Less then 3 occurrences of c - cannot be a substring - return 0;
        if (cCounter <= 2)
            return 0;

        // After the 2 first c characters found - each additional c character means one more substring that we look for.
        // Therefore - the number of substrings that we look for is the count of c characters, subtracting the
        // 2 first occurrences.
        return cCounter - 2;
    }

    // Question 2.b
    // ------------

    /**
     * Counts the number of substrings that starts and ends with a specific character,
     * and contains this character k times at most.
     * Time complexity: O(n)
     * Memory complexity: O(1)
     */
    public static int subStrMaxC(String s, char c, int k) {
        // Count the number occurrences of c in s. This operation is O(n).
        int cCounter = countCharInString(s, c);

        // If c is contained one time or not contained at all in s - we cannot build a substring from this.
        // Return 0 substring;
        if (cCounter <= 1)
            return 0;

        // We cannot find substrings with k characters if counter is lower than (k + 2).
        // e.g. k = 3, s = cAcAcAc - this string contains only k=2 substring.
        // In this cases we should change k to the maximum possible k = cCounter - 2.
        if (k > cCounter - 2)
            k = cCounter - 2;


        // The number of substrings is the sum of arithmetic progression:
        //  n = (k+1)
        //  a1 = 2(cCount-k-1)
        //
        // e.g. s = cabcbcabcacabc ==> cCount = 6
        // k = 0 substr = 5
        // k = 1 substr = 5 + 4
        // k = 2 substr = 5 + 4 + 3
        // k = 3 substr = 5 + 4 + 3 + 2
        // k = 4 substr = 5 + 4 + 3 + 2 + 1
        // k > 4 substr = substr for k=4

        return ((k + 1) * (2 * cCounter - k - 2)) / 2;
    }

    // Helper method for question 2

    /**
     * Counts the occurrences of a character in a string.
     * Time complexity: O(n)
     * Memory complexity: O(1)
     */
    private static int countCharInString(String s, char c) {
        if (s == null)
            return 0;

        int len = s.length();
        int cCounter = 0;

        //Go over the string and increase counter in case the character matches.
        //This loop is O(n) - n is the number of characters in the string.
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                cCounter++;
            }
        }

        return cCounter;
    }

    // Helper methods for printing question 2

    private static void printSubStr(String s, char c) {
        out.println("count: " + s + " - " + subStrC(s, c));
    }

    private static void printSubStrMaxC(String s, char c, int k) {
        out.println("k: " + k + ", count: " + s + " - " + subStrMaxC(s, c, k));
    }

    private static void printMatrix(int[][] m) {
        int n = m.length;

        out.print("\r\n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                out.print(m[i][j] + "  ");
            }

            out.print("\r\n");
        }

        out.print("\r\n");
    }

    private static void printFindValTest(int[][] m, int val) {
        out.println("val: " + val + ", findValTest: " + findValTest(m, val));
    }

    private static void printFindValWhat(int[][] m, int val) {
        out.println("val: " + val + ", findValWhat: " + findValWhat(m, val));
    }

    // Main

    public static void main(String[] args) {
        int[][] whatMatrix = {
                {3, 6, 9, 11},
                {4, 7, 20, 21},
                {5, 8, 21, 22},
                {6, 8, 22, 23}};

        int[][] testMatrix = {
                {2, 5, 10, 12},
                {23, 15, 14, 12},
                {25, 30, 24, 30},
                {37, 30, 35, 32}};

        printMatrix(whatMatrix);

        printFindValWhat(whatMatrix, 11);
        printFindValWhat(whatMatrix, 3);
        printFindValWhat(whatMatrix, 23);
        printFindValWhat(whatMatrix, 7);

        printFindValWhat(whatMatrix, 12);
        printFindValWhat(whatMatrix, 24);
        printFindValWhat(whatMatrix, 1);

        printMatrix(testMatrix);

        printFindValTest(testMatrix, 10);
        printFindValTest(testMatrix, 35);
        printFindValTest(testMatrix, 14);
        printFindValTest(testMatrix, 24);

        printFindValTest(testMatrix, 50);
        printFindValTest(testMatrix, 31);
        printFindValTest(testMatrix, 1);

        printSubStr("abcbcabcacabcc", 'c');
        printSubStr("", 'c');
        printSubStr(null, 'c');
        printSubStr("cbc", 'c');
        printSubStr("cbb", 'c');
        printSubStr("ac", 'c');
        printSubStr("c", 'c');
        printSubStr("cc", 'c');
        printSubStr("cccccccccccccccc", 'c');
        printSubStr("cbb", 'c');
        printSubStr("abcbbcbbbbhcasdfsfcfffg", 'c');

        out.println("\r\n");

        printSubStrMaxC("abcbcabcacab", 'c', 0);
        printSubStrMaxC("abcbcabcacab", 'c', 1);
        printSubStrMaxC("abcbcabcacab", 'c', 2);
        printSubStrMaxC("abcbcabcacab", 'c', 3);
        printSubStrMaxC("abcbcabcacab", 'c', 4);

        printSubStrMaxC("cabcbcabcacabc", 'c', 0);
        printSubStrMaxC("cabcbcabcacabc", 'c', 1);
        printSubStrMaxC("cabcbcabcacabc", 'c', 2);
        printSubStrMaxC("cabcbcabcacabc", 'c', 3);
        printSubStrMaxC("cabcbcabcacabc", 'c', 4);
        printSubStrMaxC("cabcbcabcacabc", 'c', 5);
        printSubStrMaxC("cabcbcabcacabc", 'c', 10);
    }
}
