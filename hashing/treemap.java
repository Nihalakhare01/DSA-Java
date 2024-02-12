package hashing;

import java.util.TreeMap;

public class treemap { //O(logn)  //alhphabetical order
     public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();
    
        tm.put("India",100);
        tm.put("China",150);
        tm.put("US",50);
        tm.put("UK",70);
        tm.put("Nepal",6);

        System.out.println(tm);
    }
}
