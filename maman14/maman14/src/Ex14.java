import static java.lang.System.out;

public class Ex14 {
    public static void main(String[] args) {
        int mat1[][] = {{12, 22, 23, 56}, {43, 35, 21, 20}, {34, 21, 43, 21}, {25, 30, 0, 20}, {0, 22, 10, 10}, {20, 13, 3, 45}};

        int mat2[][] = {{11, 20, 10, 11}, {13, 21, 31, 11}, {10, 12, 21, 10}, {0, 19, 10, 10}};

        int mat3[][] = {{11, 20, 10, 11}, {13, 0, 31, 11}, {10, 12, 21, 10}, {0, 19, 10, 10}};

        printCountPaths(mat1);
        printCountPaths(mat2);
        printCountPaths(mat3);
    }

    // Question 1

    public static int countPaths(int[][] mat) {
        return countPaths(mat, 0, 0);
    }

    public static int countPaths(int[][] mat, int row, int col) {
        //If the row exceeds the matrix rows - this path is not valid - return 0
        if (row > mat.length - 1) {
            return 0;
        }

        //If the column exceeds the matrix columns - this path is not valid - return 0
        if (col > mat[row].length - 1) {
            return 0;
        }

        //If this cell is the bottom right cell of the matrix - this path is valid - return 1
        if (row == mat.length - 1 && col == mat[row].length - 1) {
            return 1;
        }

        //If the current cell value is 0 - we cannot advance from here
        //and it's not the last cell - we already checked it
        //It's not a valid path - return 0
        if (mat[row][col] == 0)
            return 0;

        //Extract the left and right digits
        int valRight = mat[row][col] % 10;
        int valLeft = mat[row][col] / 10;

        //Continue the path in the matrix
        int firstCount = countPaths(mat, valRight + row, valLeft + col);
        int secondCount = 0;

        //If the left and right digits are equal - there is only one path option here - don't do the second check.
        //If not equal, there are 2 paths from here - need to check the
        if (valLeft != valRight)
            secondCount = countPaths(mat, valLeft + row, valRight + col);

        return firstCount + secondCount;
    }

    private static void printCountPaths(int[][] mat) {
        out.println();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                out.print(mat[i][j] + ", ");
            }

            out.println();
        }

        out.println("\r\ncount path: " + countPaths(mat));
    }
}
