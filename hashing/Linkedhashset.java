package hashing;
import java.util.*;
import java.util.HashSet;

public class Linkedhashset {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Nagpur");
        cities.add("Noida");
        System.out.println(cities);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Mumbai");
        lhs.add("Nagpur");
        lhs.add("Noida");
        System.out.println(lhs);
     }
}
