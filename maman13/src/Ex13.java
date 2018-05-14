import static java.lang.System.out;

public class Ex13 {
    public static void main(String[] args) {
        printweight(5358, 5);
        printweight(41358, 4);
        printweight(41358, 1);
        printweight(41358, 3);
        printweight(41358, 5);
        printweight(41358, 8);
        printweight(41358, 9);

        // printReverse(123456);
        // printReverse(12345);
        printReverse(1234);
        printReverse(123);
        printReverse(12);
        printReverse(1);
        printReverse(0);
    }

    private static void printweight(int num, int digit) {
        out.println("weight of " + num + "," + digit + " is: by not recursive: " + weight(num, digit)
                + ", by recursive: " + weightRec(num, digit));
    }

    private static void printReverse(int num) {
        out.println("reverse of " + num + " is: by not recursive: " + reverse(num) + ", by recursive: "
                + reverseRec(num));
    }

    public static int weight(int num, int digit) {
        int weight = 1;

        while (num > 0) {
            if (num % 10 == digit)
                return weight;

            weight *= 10;
            num /= 10;
        }

        return 0;
    }

    public static int weightRec(int num, int digit) {
        if (num == 0)
            return 0;

        if (num % 10 == digit)
            return 1;

        return weightRec(num / 10, digit) * 10;
    }

    public static int reverse(int num) {
        int reversedNum = 0;

        while (num > 0) {
            reversedNum *= 10;
            reversedNum += num % 10;
            num = num / 10;
        }

        return reversedNum;
    }

    public static int reverseRec(int num) {
        return reverseRec(num, 0);
    }

    public static int reverseRec(int num, int reversedNum) {
        if (num == 0)
            return reversedNum;

        reversedNum = reversedNum * 10 + num % 10;

        return reverseRec(num / 10, reversedNum);
    }
}
