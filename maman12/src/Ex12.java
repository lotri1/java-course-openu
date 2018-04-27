import static java.lang.System.out;

public class Ex12 {
    public static int subStrC(String s, char c) {
        if (s == null)
            return 0;

        int len = s.length();
        int sCounter = 0;

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                sCounter++;
            }
        }

        if (sCounter <= 2)
            return 0;

        return sCounter - 2;
    }

    private static void printSubStr(String s, char c) {
        out.println("count: " + s + " - " + subStrC(s, c));
    }

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
    }
}
