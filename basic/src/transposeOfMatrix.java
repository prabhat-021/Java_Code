import java.util.Scanner;

public class transposeOfMatrix {

    static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] transpose(int[][] arr, int r, int c) {
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = arr[j][i];
            }
        }
        return matrix;
    }

    static void swapElement(int[][] arr, int i, int j) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    static void transposeInPlace(int[][] arr, int r, int c) {
        for (int i = 0; i < r; i++) {
            for (int j = i; j < c; j++) {
                swapElement(arr, i, j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the No. Of Rows and Column:-");
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] matrix = new int[r][c];
        int totalElement = r * c;
        System.out.println("enter" + totalElement + "Elements");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        printMatrix(matrix);
        int[][] transpose = transpose(matrix, r, c);
        System.out.println("Transpose of Matrix is");
        printMatrix(transpose);

        System.out.println("In Place Transpose of Matrix is");
        transposeInPlace(matrix, r, c);
    }
}
