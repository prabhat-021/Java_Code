package Arrays;

import java.util.Arrays;

public class BoatsSavePeople {
    public static void main(String[] args) {

    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                ++ans;
                i++;
                j--;
            } else if (people[i] == limit) {
                ++ans;
                i++;
            } else if (people[j] == limit) {
                ++ans;
                j--;
            } else {
                ++ans;
                j--;
            }
        }
        return ans;
    }
}
