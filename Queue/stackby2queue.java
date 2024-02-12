package Queue;
import java.util.*;

//stack implementation by using 2 queue 
//there are two ways to perform this
//1.push O(n) -> add o(n) remove,peek o(1)
//2.pop O(n) -> remove,peek o(n) add o(1)

//this is done by using 2 way push O(n)
public class stackby2queue {
    static class stack{
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data){
            if (!q1.isEmpty()) {
                q1.add(data);
            }else{
                q2.add(data);
            }
        }

        public static int pop(){
            if(isEmpty()){
                System.out.println("Stack Empty");
                return -1;
            }

            int top = -1;

            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top = q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }else{
                while(!q2.isEmpty()){
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top; 
        }

            public static int peek(){
                if(isEmpty()){
                    System.out.println("Stack Empty");
                    return -1;
                }
    
                int top = -1;
    
                if(!q1.isEmpty()){
                    while(!q1.isEmpty()){
                        top = q1.remove();
                        q2.add(top);
                    }
                }else{
                    while(!q2.isEmpty()){
                        top = q2.remove();
                        q1.add(top);
                    }
                }
                return top; 
            }
    } 
       public static void main(String[] args) {
         stack s = new stack();
         s.push(1);
         s.push(2);
         s.push(3);

         while (!s.isEmpty()) {
            System.out.println(s.peek()+" ");
            s.pop();
         }
    } 
}
