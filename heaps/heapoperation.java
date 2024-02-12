package heaps;

import java.util.ArrayList;

public class heapoperation {
    
    static class heap {
        ArrayList<Integer> arr = new ArrayList<>();
        
        public void add(int data){ // O(log n)
            //add at last idx
            arr.add(data);

            int x = arr.size()-1; // x is child index
            int par = (x-1)/2; // par index

            while (arr.get(x) < arr.get(par)) {  // O(log n) // for max heap chsnge sign to > also change name minidx to maxidx
                //swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par,temp);

                x = par;
                par = (x-1)/2;
            }
        } 
        
        public int peek(){
            return arr.get(0);
        }

        public void heapify(int i){
            int left = 2*i+1;
            int right = 2*i + 2;
            int minidx = i;

            if(left < arr.size() && arr.get(minidx) > arr.get(left)){ // for max heap change sign to < also change name minidx to maxidx
                minidx = left;
            }

            if (right < arr.size() && arr.get(minidx)> arr.get(right)) {  // for max heap change sign to < also change name minidx to maxidx
                minidx = right;
            }

            if (minidx != i) {
                //swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minidx));
                arr.set(minidx, temp);

                heapify(minidx);
            }
        }

        public int remove(){
            int data = arr.get(0);

            //step1 - swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //step2 - delete last
            arr.remove(arr.size()-1);

            //step3 - heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
         heap pq = new heap();
         pq.add(3);
         pq.add(4);
         pq.add(1);
         pq.add(5);

         while (!pq.isEmpty()) {
            System.out.print(pq.peek()+" ");
            pq.remove();
         }          
    }
}
