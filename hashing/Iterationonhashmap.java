package hashing;

import java.util.HashMap;
import java.util.Set;

public class Iterationonhashmap {
    public static void main(String[] args) {
         HashMap<String, Integer> hm = new HashMap<>();

        //Insert -O(1)
        hm.put("India",100);
        hm.put("China",150);
        hm.put("US",50);
        hm.put("UK",70);
        hm.put("Nepal",6);

        //Iterate
        //hm.entryset()
        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String k : keys) {
                System.out.println("key="+k+",value="+hm.get(k));
        }
        
    }
}
