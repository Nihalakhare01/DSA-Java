package Queue;
import java.util.*;
public class interleave2halves {
    public static void interleave(Queue<Integer> q){

        Queue<Integer> q1 = new LinkedList<>();
        int i=0;
        int size = q.size();
        while(i < size/2){ 
            q1.add(q.remove());
            i++;
        }
        while(!q1.isEmpty()){
            q.add(q1.remove());
            q.add(q.remove());
        }
   //     System.out.print(q);
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=10; i++){
                q.add(i);
        }
        interleave(q);
        while (!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove(); 
        }
    }   
}
