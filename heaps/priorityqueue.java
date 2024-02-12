package heaps;

import java.util.PriorityQueue;

public class priorityqueue {
    static class  student implements Comparable<student> {
    String name;
    int rank;

    public student(String name, int rank){
        this.name = name;
        this.rank = rank;
    }
    
    @Override
    public int compareTo(student s2){
        return this.rank - s2.rank;
    }
}
    
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(3); //O(log n)
        pq.add(4);
        pq.add(1);
        pq.add(7);
       
        while (!pq.isEmpty()) {
            System.out.print(pq.peek()+" "); //O(1)
            pq.remove();        //O(logn)
        }
    }
}
