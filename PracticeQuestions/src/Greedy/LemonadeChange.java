package Greedy;

public class LemonadeChange {
    public static void main(String[] args) {

    }

    public boolean lemonadeChange(int[] bills) {
        int count5 = 0, count10 = 0;
        boolean flag = true;
        for (int bill : bills) {
            if (bill == 5) count5++;
            else if (bill == 10) {
                count10++;
                if (count5 > 0) count5--;
                else return false;
            } else {
                if (count10 > 0) {
                    count10--;
                    if (count5 > 0) {
                        count5--;
                    } else return false;
                } else if (count5 > 2) {
                    count5 -= 3;
                } else return false;
            }
        }

        return flag;
    }
}
