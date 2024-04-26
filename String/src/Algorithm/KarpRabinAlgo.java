package Algorithm;

public class KarpRabinAlgo {
    public static void main(String[] args) {
        search("apoorvprabhatRahul", "prabhat");
    }

    private static final int PRIME = 101;

    private static long calculateHash(String str) {
        long hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = hash + str.charAt(i) * (long) Math.pow(PRIME, i);
        }
        return hash;
    }

    private static long updateHash(long prevHash, char oldChar, char newChar, int patternLength) {
        long newHash = (prevHash - oldChar) / PRIME;
        newHash = newHash + newChar * (long) Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    public static void search(String text, String pattern) {
        int patternLength = pattern.length();
        long patternHash = calculateHash(pattern);
        long textHash = calculateHash(text.substring(0, patternLength));
        boolean check = false;

        for (int i = 0; i <= text.length() - patternLength; i++) {
            if (textHash == patternHash) {
                if (text.substring(i, i + patternLength).equals(pattern)) {
                    check = true;
                    System.out.println("Pattern found at index:-" + i);
                }
            }

            if (i < text.length() - patternLength) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }
        }

        if (!check) {
            System.out.println("Pattern Not Found");
        }
    }
}
