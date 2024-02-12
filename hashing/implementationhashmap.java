package hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class implementationhashmap {
    static class Hashmap<K,V> { //generic
        private class Node {
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }    
        }

        private int n; //n
        private int N;
        private LinkedList<Node> bucket[]; //N = bucket.length;
    
        @SuppressWarnings("unchecked")
        public Hashmap(){
            this.N=4;
            this.bucket = new LinkedList[4];
            for(int i=0; i<4; i++){
                this.bucket[i] = new LinkedList<>();
            }
        }

        private int hashfunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        public int SearchInull(K key, int bi){

            LinkedList<Node> ll = bucket[bi];
            int di=0;
            for(int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if (node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

            @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBuck[] = bucket;
            bucket = new LinkedList[N*2];
            N = 2*N;
            for(int i=0; i<bucket.length; i++){
                bucket[i] = new LinkedList<>();
            }

            //nodes -> add in bucket
            for(int i=0; i<oldBuck.length; i++){
                LinkedList<Node> ll = oldBuck[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }   
        }

        public void put(K key, V value){ //O(lambda) -> O(1)
            int bi = hashfunction(key);
            int di = SearchInull(key,bi); 

            if (di != -1) { // valid
                Node node = bucket[bi].get(di);
                node.value = value;
            }else{
                bucket[bi].add(new Node(key,value));
                n++;
            }

            double lambda = (double)n/N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key){
           int bi = hashfunction(key);
            int di = SearchInull(key,bi); // valid

            if (di != -1) {
                return true;
            }else{
               return false;
            }
        }

        public V remove(K key){  //O(1)
           int bi = hashfunction(key);
            int di = SearchInull(key,bi); // valid

            if (di != -1) {
                Node node = bucket[bi].remove(di);
                n--;
                return node.value;
            }else{
                return null;
            }
        }

        public V get(K key){ //O(1)
            int bi = hashfunction(key);
            int di = SearchInull(key,bi); // valid

            if (di != -1) {
                Node node = bucket[bi].get(di);
              return  node.value;
            }else{
                return null;
            }
        }
    
        public ArrayList<K> keyset(){
         ArrayList<K> keys = new ArrayList<>();

         for(int i=0;  i<bucket.length; i++){
                LinkedList<Node> ll = bucket[i];
                for(Node node : ll){
                    keys.add(node.key);
                }
          }
          return keys;
        }

        public boolean isEmpty(){
            return n == 0;
        }
    }

    public static void main(String[] args) {
        Hashmap<String , Integer> hm = new Hashmap<>();
        hm.put("India",100);
        hm.put("China",150);
        hm.put("US",50);
        hm.put("UK",70);
        hm.put("Nepal",6);

        ArrayList<String> keys = hm.keyset();
        for (String key : keys) {
            System.out.println(key);  
        }
        System.out.println(hm.get("India"));
         System.out.println(hm.remove("India"));
          System.out.println(hm.get("India"));
    }
}
