public class PrintAllSubsequences {
    public static void main(String[] args) {
        printSSQ("abc", "");
    }

    static void printSSQ(String s, String currAns) {
//        base case
        if (s.length() == 0) {
            System.out.println(currAns);
            return;
        }


        char curr = s.charAt(0);
        String remString = s.substring(1);

//        Curr char --> chooses to be part of currAns
        printSSQ(remString, currAns + curr);

//        Curr char --> chooses not to be part of currAns
        printSSQ(remString, currAns);

    }
}
