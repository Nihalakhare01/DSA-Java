package Queue;
import java.util.*;

import Queue.queueby2stack.queue;

public class stackqueuebydq {
    static class stack {
        Deque<Integer> dq = new LinkedList<>();

        public void push(int data){
            dq.addLast(data);
        }

        public int pop(){
            return dq.removeLast();
        }

        public int peek(){
            return dq.getLast();
        }
    }

    static class queuebydq {
        Deque<Integer> dq = new LinkedList<>();

        public void add(int data){
            dq.addLast(data);
        }

        public int pop(){
            return dq.removeFirst();
        }

        public int peek(){
            return dq.getFirst();
        } 
        
    }

    public static void main(String[] args) {
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println("peek = "+s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());

        queue q = new queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println("peek = "+q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());   
    } 
}
