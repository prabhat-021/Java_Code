import java.util.ArrayList;
import java.util.List;

public class SmallestNumber {
    public static void main(String[] args) {

    }

    public static List<Integer> number(int S, int D) {
        if (S == 0 || S > D * 9) return List.of(-1);
        S -= 1;
        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < D; i++) {
            number.add(0);
        }

        number.set(0, 1);
        for (int i = D - 1; i >= 0; i--) {
            if (S > 9) {
                number.set(i, 9);
                S -= 9;
            } else {
                number.set(i, S);
                break;
            }
        }

        number.set(0, S + 1);
        return number;
    }
}
