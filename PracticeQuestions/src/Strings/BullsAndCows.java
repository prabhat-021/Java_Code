package Strings;

import java.util.HashMap;

public class BullsAndCows {
    public static void main(String[] args) {
        String secret = "1122";
        String guess = "1222";
        System.out.println(getHint(secret, guess));
    }

    public static String getHint(String secret, String guess) {
        int bullCount = 0, cowCount = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            mp.put(secret.charAt(i), mp.getOrDefault(secret.charAt(i), 0) + 1);
        }
        String random = "";
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i) && mp.containsKey(guess.charAt(i))) {
                bullCount++;
                mp.put(guess.charAt(i), mp.get(guess.charAt(i)) - 1);
                if (mp.get(guess.charAt(i)) == 0) {
                    mp.remove(guess.charAt(i));
                }
            } else {
                random += guess.charAt(i);
            }
        }

        for (int i = 0; i < random.length(); i++) {
            if (mp.containsKey(random.charAt(i))) {
                cowCount++;
                mp.put(random.charAt(i), mp.get(random.charAt(i)) - 1);
                if (mp.get(random.charAt(i)) == 0) {
                    mp.remove(random.charAt(i));
                }
            }
        }


        return bullCount + "A" + cowCount + "B";
    }

}
