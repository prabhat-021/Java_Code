import java.util.HashMap;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        HashMapMethods();
    }

    static void HashMapMethods() {
//        Syntax
        Map<String, Integer> mp = new HashMap<>();
//        Adiing elements
        mp.put("Akash", 28);
        mp.put("Prabhat", 38);
        mp.put("raju", 18);
        mp.put("lav", 48);
        mp.put("ramesh", 58);
        mp.put("Manish", 68);

//       Getting the values
        System.out.println(mp.get("Akash"));

//        Remove a pair from the HashMap
        mp.remove("Akash");

//        Checking if a Key is in the HashMap
        System.out.println(mp.containsKey("Akash"));
        System.out.println(mp.containsKey("raju"));

//      Adding a new entry only if the new key doesn't exist already
        mp.putIfAbsent("Yashika", 78);

//        Get all the keys in hashMap
        System.out.println(mp.keySet());
        ;

//        Get all the values in hashMap
        System.out.println(mp.values());
        ;

//        Get all the entries in hashMap
        System.out.println(mp.entrySet());

//        Traversing All entries of Hashmap - multiple methods
        for (String key : mp.keySet()) {
            System.out.printf("Age of %s is %d\n", key, mp.get(key));
        }
        System.out.println();

        for (Map.Entry<String, Integer> e : mp.entrySet()) {
            System.out.printf("Age of %s is %d\n", e.getKey(), e.getValue());
        }
        System.out.println();

    }
}