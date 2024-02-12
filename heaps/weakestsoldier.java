package heaps;

import java.util.PriorityQueue;



public class weakestsoldier {
    static class row implements Comparable<row> {
        int soldiers;
        int idx;

        public row(int soldiers, int idx){
            this.soldiers = soldiers;
            this.idx = idx;
        }
        @Override
        public int compareTo(row r2){
            if (this.soldiers ==  r2.soldiers) {
                return this.idx - r2.idx;
            }else{
                return this.soldiers-r2.soldiers;
            }
        }   
    }
    public static void main(String[] args) {
        int arr[][] = {{1,0,0,0},
                        {1,1,1,1},
                        {1,0,0,0},
                        {1,0,0,0}};

        int k=2;

        PriorityQueue<row> pq = new PriorityQueue<>();

        for(int i=0; i<arr.length; i++){
            int count = 0;
            for(int j=0; j<arr.length; j++){
                count += arr[i][j] == 1 ? 1:0;
            }   
            pq.add(new row(count, i));
        }
        for(int i=0; i<k; i++){
            System.out.println("R"+pq.remove().idx);
        }
    }
}
