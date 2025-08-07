import java.util.Arrays;

public class MatrixCalculator {

    public static int[][] add(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[i][j] = A[i][j] + B[i][j];

        return result;
    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++)
            for (int j = 0; j < colsB; j++)
                for (int k = 0; k < colsA; k++)
                    result[i][j] += A[i][k] * B[k][j];

        return result;
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                transposed[j][i] = matrix[i][j];

        return transposed;
    }

    public static int findMax(int[][] matrix) {
        int max = matrix[0][0];
        for (int[] row : matrix)
            for (int val : row)
                if (val > max) max = val;
        return max;
    }

    public static int findMin(int[][] matrix) {
        int min = matrix[0][0];
        for (int[] row : matrix)
            for (int val : row)
                if (val < min) min = val;
        return min;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }

    public static void main(String[] args) {
        int[][] A = {
            {1, 2},
            {3, 4}
        };

        int[][] B = {
            {5, 6},
            {7, 8}
        };

        System.out.println("Matrix A:");
        printMatrix(A);

        System.out.println("\nMatrix B:");
        printMatrix(B);

        System.out.println("\nA + B:");
        printMatrix(add(A, B));

        System.out.println("\nA x B:");
        printMatrix(multiply(A, B));

        System.out.println("\nTranspose of A:");
        printMatrix(transpose(A));

        System.out.println("\nMax of A: " + findMax(A));
        System.out.println("Min of A: " + findMin(A));
    }
}
