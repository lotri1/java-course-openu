import static java.lang.System.out;

public class Ex13 {
    // Question 1.a.1

    /**
     * Returns the weight of the first occurrence of digit in num
     */
    public static int weight(int num, int digit) {
        int weight = 1;

        while (num > 0) {
            // If the most right digit is the searched digit - return the current weight
            if (num % 10 == digit)
                return weight;

            // If not - increase the weight to the next iteration
            weight *= 10;

            // Move to the next digit by dividing by 10
            num /= 10;
        }

        return 0;
    }

    // Question 1.a.2

    /**
     * Returns the weight of the first occurrence of digit in num - Recursive
     * version
     */
    public static int weightRec(int num, int digit) {
        if (num == 0)
            return 0;

        // If the most right digit is the searched digit - the weight is 1
        if (num % 10 == digit)
            return 1;

        //Otherwise - give the recursion handle a smaller number.
        return weightRec(num / 10, digit) * 10;
    }

    // Question 1.b.1

    /**
     * Reverse a number digits
     */
    public static int reverse(int num) {
        int reversedNum = 0;

        while (num > 0) {
            reversedNum *= 10; //Prepare the place for the next digit by multiplying by 10.
            reversedNum += num % 10; //Extract the right digit from the number and add it to the reversed number
            num = num / 10; //Move to the next digit
        }

        return reversedNum;
    }

    // Question 1.b.2

    /**
     * Reverse a number digits - recursive version
     */
    public static int reverseRec(int num) {
        return reverseRec(num, 0);
    }

    private static int reverseRec(int num, int reversedNum) {
        if (num == 0)
            return reversedNum;

        //Make a place for the new digit and add to the reversed number the right digit of num
        reversedNum = reversedNum * 10 + num % 10;

        //Call the recursion to handle the rest of the number
        return reverseRec(num / 10, reversedNum);
    }

    // Question 2.a

    /**
     * Calculate the number of options that spiderman can climb on a building with n floors.
     * Spiderman can climb 1 or 2 floors in each step.
     */
    public static int spiderman(int n) {
        if (n == 0) //Spideman is on the roof - count this
            return 1;

        if (n < 0) //Spideman missed the roof - don't count this
            return 0;

        //In each step of the recursion try 2 options - climb 1 floor, climb 2 floors
        //This will cover all the combinations to climb
        return spiderman(n - 1) + spiderman(n - 2);
    }

    // Question 2.b

    /**
     * Calculate the number of options that spiderman can climb on a building with n floors.
     * Spiderman can climb 1 or 2 floors in each step.
     * If he reaches the phone boot in the 20 floor - he can go from there straight to the roof.
     */
    public static int spidermanPhoneBooth20(int n) {
        return spidermanPhoneBooth20(n, 0);
    }

    private static int spidermanPhoneBooth20(int n, int currentFloor) {
        //If he reached the roof (currentFloor == n) or he reached the 20 floor in a building higher than 20 floors.
        //The check if the building has 20 floors or more, prevents counting paths that exceeds the roof in 19 floors
        // buildings.
        if (currentFloor == n || (currentFloor == 20 && n >= 20))
            return 1;

        //Missed the roof
        if (currentFloor > n)
            return 0;

        //In each step of the recursion try 2 options - climb 1 floor, climb 2 floors
        return spidermanPhoneBooth20(n, currentFloor + 1) + spidermanPhoneBooth20(n, currentFloor + 2);
    }

    // Main

    public static void main(String[] args) {
        printweight(5358, 5);
        printweight(41358, 4);
        printweight(41358, 1);
        printweight(41358, 3);
        printweight(41358, 5);
        printweight(41358, 8);
        printweight(41358, 9);

        out.println("\r\n---------------------------\r\n");

        printReverse(1234);
        printReverse(123);
        printReverse(12);
        printReverse(1);
        printReverse(0);

        out.println("\r\n---------------------------\r\n");

        printSpiderman(1);
        printSpiderman(2);
        printSpiderman(3);
        printSpiderman(4);
        printSpiderman(5);
        printSpiderman(6);
        printSpiderman(7);
        printSpiderman(8);
        printSpiderman(9);
        printSpiderman(10);
        printSpiderman(19);
        printSpiderman(20);

        out.println("\r\n---------------------------\r\n");

        printSpidermanPhoneBooth20(18);
        printSpidermanPhoneBooth20(19);
        printSpidermanPhoneBooth20(20);
        printSpidermanPhoneBooth20(21);
        printSpidermanPhoneBooth20(22);
        printSpidermanPhoneBooth20(23);
        printSpidermanPhoneBooth20(24);
    }

    // Helpers for printing

    private static void printweight(int num, int digit) {
        out.println("weight of (" + num + "," + digit + ") is: by not recursive: " + weight(num, digit)
                + ", by recursive: " + weightRec(num, digit));
    }

    private static void printReverse(int num) {
        out.println(
                "reverse of (" + num + ") is: by not recursive: " + reverse(num) + ", by recursive: " + reverseRec(num));
    }

    private static void printSpiderman(int n) {
        out.println("spiderman of " + n + " is: " + spiderman(n));
    }

    private static void printSpidermanPhoneBooth20(int n) {
        out.println("spidermanPhoneBooth20 of " + n + " is: " + spidermanPhoneBooth20(n));
    }
}
