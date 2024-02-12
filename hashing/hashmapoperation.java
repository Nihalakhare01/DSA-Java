package hashing;

import java.util.HashMap;


public class hashmapoperation {
    public static void main(String[] args) {
        //create
        HashMap<String, Integer> hm = new HashMap<>();

        //Insert -O(1)
        hm.put("India",100);
        hm.put("China",150);
        hm.put("US",50);

        System.out.println(hm);

        // //size
        // System.out.println(hm.size());

        //isEmpty
        
        System.out.println(hm.isEmpty());

        //get - O(1)
        int population = hm.get("India");
        System.out.println(population);

        System.out.println(hm.get("Indonesia"));

        //contains key - O(1)
        System.out.println(hm.containsKey("India")); //true
          System.out.println(hm.containsKey("Indonesia")); //false

          //remove - O(1)
          System.out.println(hm.remove("China"));
          System.out.println(hm.remove("Japan"));

          //clear
          hm.clear();
    } 
}
