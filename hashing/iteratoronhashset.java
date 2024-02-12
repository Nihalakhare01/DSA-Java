package hashing;
 import java.util.*;
public class iteratoronhashset {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Nagpur");
        cities.add("Noida");

        // Iterator it = cities.iterator();
        // while (it.hasNext()) {
        //     System.out.println(it.next());

        //Advanced way for iteration

        for (String city : cities) {
            System.out.println(city);
         }
     }
 }

