package hashing;

import java.util.HashMap;
import java.util.Set;

public class majorityelement {
    public static void main(String[] args) {
        int arr[] = {1,3,2,5,1,3,1,5,1};
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            // if (map.containsKey(arr[i])) {
            //     map.put(arr[i], map.get(arr[i]+1));
            // }else{
            //     map.put(arr[i], 1);
            // }

            //instead of above 4 lines simply we can write only one line

            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        Set<Integer> keyset = map.keySet();  // remove this line and simply write this
                                                     //       |
        for (Integer key : keyset) {      //for (Integer key : map.keyset()) 
            if (map.get(key) > arr.length/3) {
                System.out.println(key);
            }   
        }
    }
    
}
