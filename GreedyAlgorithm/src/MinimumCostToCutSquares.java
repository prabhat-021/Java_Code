import java.util.Comparator;
import java.util.List;

public class MinimumCostToCutSquares {
    public static void main(String[] args) {

    }

    public static int minimumCost(List<Integer> X, List<Integer> Y, int M, int N) {
        X.sort(Comparator.reverseOrder());
        Y.sort(Comparator.reverseOrder());

        int no_of_Vertical_Piece = 1;
        int no_of_Horizontal_Piece = 1;
        int totalcost = 0;
        int i = 0, j = 0;

        while (i < M - 1 && i < N - 1) {
            if (X.get(i) > Y.get(j)) {
                totalcost += X.get(i++) * no_of_Horizontal_Piece;
                no_of_Vertical_Piece++;
            } else {
                totalcost += Y.get(j++) * no_of_Vertical_Piece;
                no_of_Horizontal_Piece++;
            }
        }
        while (i < M - 1) totalcost += X.get(i++) * no_of_Horizontal_Piece;
        while (j < N - 1) totalcost += Y.get(j++) * no_of_Vertical_Piece;
        System.out.println(totalcost);
        return totalcost;
    }
}
