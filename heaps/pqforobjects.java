package heaps;
import java.util.Comparator;
import java.util.PriorityQueue;
public class pqforobjects {
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
        PriorityQueue<student> pq = new PriorityQueue<>(Comparator.reverseOrder()); // comparator for reverse order

         //O(log n)
         pq.add(new student("A", 4));
         pq.add(new student("B", 5));
         pq.add(new student("C", 2));
         pq.add(new student("D", 12));
    
       
        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name+"->"+pq.peek().rank); //O(1)
            pq.remove();        //O(logn)
        }
    }
}

    

