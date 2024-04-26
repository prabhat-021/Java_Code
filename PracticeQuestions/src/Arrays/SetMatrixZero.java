package Arrays;

import java.util.*;

public class SetMatrixZero {
    public static void main(String[] args) {
//        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
//        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
//        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
//        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
//
//        int n = matrix.size();
//        int m = matrix.get(0).size();
//
////        ArrayList<ArrayList<Integer>> ans = setZeroes(matrix);
//
//        System.out.println("The Final matrix is: ");
//        for (ArrayList<Integer> row : ans) {
//            for (Integer ele : row) {
//                System.out.print(ele + " ");
//            }
//            System.out.println();
//        }
    }

//      BRUTE APPROACH WITH N3 COMPLEXITY !!
//
//    public void setZeroes(int[][] matrix) {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == 0) {
//                    markRow(matrix, i);
//                    markCol(matrix, j);
//                }
//            }
//        }
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if (matrix[i][j] == -1) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//    }
//
//    public void markRow(int[][] matrix, int i) {
//        for (int j = 0; j < matrix.length; j++) {
//            if (matrix[i][j] != 0) {
//                matrix[i][j] = -1;
//            }
//        }
//    }
//
//    public void markCol(int[][] matrix, int i) {
//        for (int j = 0; j < matrix.length; j++) {
//            if (matrix[i][j] != 0) {
//                matrix[i][j] = -1;
//            }
//        }
//    }


    //
//   OPTIMAL APPROACH
//
    class Solution {
        public void setZeroes(int[][] matrix) {
            int col0 = 1;
//    Marking in this loop
//        int col[m] ={0};  --> matrix[0][...]
//        int row[n] ={0};  --> matrix[...][0]

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
//                Mark the rows
                        matrix[i][0] = 0;
//                Mark the Col
                        if (j != 0) {
                            matrix[0][j] = 0;
                        } else {
                            col0 = 0;
                        }
                    }
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][j] != 0) {
                        if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                            matrix[i][j] = 0;
                        }
                    }
                }
            }
            if (matrix[0][0] == 0) {
                for (int i = 0; i < matrix[0].length; i++) {
                    matrix[0][i] = 0;
                }
            }
            if (col0 == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }

        }
    }


}
