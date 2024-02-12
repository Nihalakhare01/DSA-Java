package greedyalgorithm;
public class j01  {
    public static class node {
            int data;
            node next;

             public node(int data){
                this.data=data;
                this.next=null;
             }
        }

        public static node head;
        public static node tail;  
        public static int size;
    
    
    public void addfirst(int data){
        node nn = new node(data);
         size++;
        if(head == null){
                head = tail = nn;
                return;
            }
        nn.next = head;
        head = nn;
       
    }

    public void addlast(int data){
        node nn = new node(data);
         size++;
            if(head == null){
                head=tail=null;
                return;
            }
            tail.next = nn;
            tail = nn;
    }

    public void insert(int idx, int data){
        if(idx == 0){
            addfirst(data);
            return;
        }

            node nn = new node(data);
            size++;
            int i = 0;
            node temp = head;

            while(i<idx-1){
                i++;
                temp= temp.next;
            }
            nn.next = temp.next;
            temp.next = nn;
        }

    public int removefirst(){
        if(size == 0){
            System.out.println("LL is Empty");
            return 0;
        }
        if (size == 1) {
            int val = head.data;
            head=tail=null;
            size=0;
            return val;
        }
        
        int val = head.data;
        head=head.next;
        size--;
        return val;
    }

    public int removelast(){
         if(size == 0){
            System.out.println("LL is Empty");
            return 0;
        }
        if (size == 1) {
            int val = head.data;
            head=tail=null;
            size=0;
            return val;
        }

        node temp = head;
       for(int i=0; i<size-2; i++){
            temp = temp.next;
       }
       int val = temp.next.data;
       temp.next=null;
       tail = temp;
       size--;
       return val;
    }

    public  int itrsearch(int key){
        int i=0;
       node temp = head;
       while(temp != null){
            if(temp.data == key){
                return i;
            }
            i++;
            temp = temp.next;
       }
       return -1;
    }

    public void reverse(){
        node next;
        node curr = tail= head;
        node prev = null;

        while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
        }
        head = prev;
    }

    public void delfromend(int n){
        node temp = head;
        int sz=0;
        while(temp!= null){
            temp = temp.next;
            sz++;
        }

        if(n == sz){
            head = head.next;
            return;
        }

        node prev = head;
        int i=1;
        while (i != sz-n) {
            prev = prev.next;
            i++;            
        }
        prev.next = prev.next.next;
    }


    public void print(){
        if(head== null){
            System.out.println("LL is Empty");
            return;
        }
        node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        j01 ll = new j01();
        ll.print();
        ll.addfirst(2);
        ll.addfirst(1);
        ll.addlast(3);
        ll.addlast(4);
     //   ll.print();
        ll.insert(3, 5);
        ll.print();
        ll.insert(0, 10);
        ll.print();
       System.out.println("size:"+size);
           ll.removefirst();
        ll.print();
       System.out.println("size:"+size);
       ll.removelast();
        ll.print();
          System.out.println("size:"+size);
       System.out.println("index:"+ ll.itrsearch(3));
           ll.reverse();
          ll.print();
         ll.delfromend(3);
         ll.print();

    }

}
