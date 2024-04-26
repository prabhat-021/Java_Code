import java.util.Scanner;

public class printSpiralOrder {
    static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void printSpiralOrder(int[][] arr, int r, int c) {
        int topRow=0,bottomRow=r-1,leftColumn=0,rightColumn=c-1;
        int total=r*c;
        while (total>0){

//            topRow=left to right col
            for(int j=leftColumn;j<=rightColumn && total>0;j++){
                System.out.print(arr[topRow][j] + " ");
                total--;
            }
            topRow++;
//            rightCol=top to bottom row
            for(int i=topRow;i<=bottomRow && total>0;i++){
                System.out.print(arr[i][rightColumn] + " ");
                total--;
            }
            rightColumn--;
//            bottomRow=right to left col
            for(int j=rightColumn;j>=leftColumn && total>0;j--){
                System.out.print(arr[bottomRow][j] + " ");
                total--;
            }
            bottomRow--;
//            leftCol=bottom to top row
            for(int i=bottomRow;i>=topRow && total>0;i--){
                System.out.print(arr[i][leftColumn] + " ");
                total--;
            }
            leftColumn++;

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
        printSpiralOrder(matrix,r,c);
    }
}
