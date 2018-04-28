import static java.lang.System.out;

public class Ex12 {
    //  Question 1.a
    //  ------------
    //      1. Not correct
    //      2. Correct
    //      3. Correct
    //      4. Not correct
    //      5. Correct
    //      6. Correct

    //  Question 1.b
    //  ------------

    public static boolean findValWhat(int[][] m, int val) {
        return false;
    }

    public static boolean findValTest(int[][] m, int val) {
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

    // Main

    public static void main(String[] args) {
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
