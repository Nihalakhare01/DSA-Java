package hashing;

import java.util.LinkedHashMap;

public class linkedhashmap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
    
        lhm.put("India",100);
        lhm.put("China",150);
        lhm.put("US",50);
        lhm.put("UK",70);
        lhm.put("Nepal",6);

        System.out.println(lhm);
    }
    
}
