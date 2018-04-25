import static java.lang.System.out;

public class Ex13 {
    public static void main(String[] args) {
        printWeight(5358, 5);
        printWeight(41358, 4);
        printWeight(41358, 1);
        printWeight(41358, 3);
        printWeight(41358, 5);
        printWeight(41358, 8);
        printWeight(41358, 9);
    }

    private static void printWeight(int num, int digit) {
        out.println("weight of " + num + "," + digit + " is: " + weight(num, digit));
    }

    public static int weight(int num, int digit) {
        if (num == 0)
            return 0;

        if (num % 10 == digit)
            return 1;

        return weight(num / 10, digit) * 10;
    }
}
