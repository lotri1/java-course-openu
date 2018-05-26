public class Ex14 {
    public static void main(String[] args) {

    }



    // Question 1

    public static int countPaths(int[][] mat) {
        return countPaths(mat, 0, 0);
    }

    public static int countPaths(int[][] mat, int row, int col) {
        if (row > mat.length - 1)
            return 0;

        if (col > mat[row].length - 1)
            return 0;

        if (row == mat.length - 1 && col == mat[row].length - 1)
            return 1;

        int valRight = mat[row][col] % 10;
        int valLeft = mat[row][col] / 10;

        return countPaths(mat, valRight + row, valLeft + col) + countPaths(mat, valLeft + row, valRight + col);
    }
}
