package Queue;

public class QueueLinkedlist {

    static class Node {
         int data;
         Node next;
         
         Node(int data){
          this.data = data;
          this.next = null;
         }
    }

    static class Queue{

        public static Node head = null;
        public static Node tail = null;


    public static boolean isEmpty(){
        return head == null && tail == null;
    }

    public static void add(int data){
        Node newnode = new Node(data);

        if (isEmpty()) {
            head = tail = newnode;
            return;
        }
            tail.next = newnode;
            tail = newnode;
        
    }

    public static int remove(){
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }

        int val = head.data;

        if(head == tail){
            head = tail = null;
        }else{
             head = head.next;
        }
        return val;
    }

    public static int peek(){
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        } 
        return head.data; 
    }
}  
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
       

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove(); 
        }     
    }
} 

