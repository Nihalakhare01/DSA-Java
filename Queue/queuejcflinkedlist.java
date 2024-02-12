package Queue;
import java.util.*;

//Queue is an interface  in java collection framework(jcf) not a class.

//ArrayDeque  and Linkedlist are the two ways to implement queue in java collection framework(jcf)
//objects cann't bre form in jcf of queue.
//there is a fifference between arraydeque and linkedlist
  
public class queuejcflinkedlist {
    public static void main(String[] args) {
       
        // Queue<Character> q  = new LinkedList<>();
        // Queue<Float> q  = new LinkedList<>();
         // Queue<Boolean> q  = new LinkedList<>();

        Queue<Integer> q  = new LinkedList<>(); //ArrayDeque
         
        q.add(1);
        q.add(2);  
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove(); 
        }

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(1);
        queue.add(2);  
        queue.add(3);

        while (!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();         
        }
    }     
}
