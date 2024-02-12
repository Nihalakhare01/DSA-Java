package Queue;
import java.util.*;

//queue implementation by using 2 stack 
//there are two ways to perform this
//1.push O(n) -> add o(n) remove,peek o(1)
//2.pop O(n) -> remove,peek o(n) add o(1)

//this is done by using 1 way push O(n)
public class queueby2stack {
    static class queue{
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    public static boolean isEmpty(){
        return s1.isEmpty();
    }

    //O(n)
    public static void add(int data){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        s1.push(data);

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    //O(1)
    public static int remove(){
        if (s1.isEmpty()) {
            System.out.println("Queue Empty!");
            return -1;
        }

        return s1.pop();
    }

    //O(1)
    public static int peek(){
        if (s1.isEmpty()) {
            System.out.println("Queue Empty!");
            return -1;
        }

        return s1.peek();
    }
} 

    public static void main(String[] args) {
        queue q = new queue();
        
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek()+" ");
            q.remove();
        }
    }
}
