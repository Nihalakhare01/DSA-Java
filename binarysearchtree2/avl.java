package binarysearchtree2;

public class avl {
    static class  Node {
        int data,height;
        Node left,right;

        public Node(int data){
            this.data= data;
            this.height=1;
        }  
    }

    public static Node root;

    public static int height(Node root){
        if (root == null) {
            return 0;
        }
        return root.height;
    } 

    static int max(int a, int b){
        return (a>b) ? a:b;    
    }

    public static int getbalance(Node root){
        if(root == null)
            return 0;
       
         return height(root.left) - height(root.right);  
    }

     //right rotate subtree rooted with y
     public static Node rightrotate(Node y){
        Node x = y.left;
        Node t2 = x.right;

        //perform rotation
        x.right = y;
        y.left = t2;
       
        //update heights
        y.height = max(height(y.left), height(y.right))+1;
        x.height = max(height(x.left), height(x.right))+1;
       
        //return new root
        return x;
    }

    //left rotate subtree rooted with x
    public static Node leftrotate(Node x){
          Node y = x.right;
        Node t2 = y.left;

        //perform rotation
        y.left = x;
        x.right = t2; 

        //update heights
        x.height = max(height(x.left), height(x.right))+1;
        y.height = max(height(y.left), height(y.right))+1;

        //return new root
        return y;
    }

    public static Node insert(Node root,int key){
       if(root == null)
            return new Node(key);

            if(key < root.data)
                root.left = insert(root.left, key);
            else if (key > root.data) 
                root.right = insert(root.right, key);
            else
                return root;    //duplicate keys are not allowed
 
            //update root height
            root.height = 1 + Math.max(height(root.left),height(root.right));

            //get roots balance
            int bf = getbalance(root);

            //left left case
            if(bf>1 && key < root.left.data)
                return rightrotate(root);
            
             //right right case
             if(bf<-1 && key > root.right.data)
                return leftrotate(root);

             //left right case
             if(bf>1 && key > root.left.data){
                root.left = leftrotate(root.left);
                return rightrotate(root);
             }

             //right left case
             if(bf < -1 && key < root.right.data){
                root.right = rightrotate(root.right);
                return leftrotate(root);
             }
            return root; //it means avl is already rotated
    } 

    public static void preorder(Node root){
        if(root == null)
            return;  

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root,10);
        root = insert(root,20);
        root = insert(root,30);
        root = insert(root,40);
        root = insert(root,50);
        root = insert(root,25);

        /*
                AVL tree
                     30
                    / \
                  20   40
                 / \    \
               10  250   50
         */ 

         preorder(root);
    }
}
