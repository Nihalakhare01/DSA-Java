package binarysearchtree2;

public class largestbstsize {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    } 
    static class info {
        boolean isbst;
        int size,min,max;

       public info(boolean isbst, int size, int min, int max){
            this.isbst = isbst;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    } 

    public static int maxbst = 0;

    public static info largestbst(Node root){
        if (root == null) {
            return new info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        info leftinfo = largestbst(root.left);
        info rightinfo = largestbst(root.right);
        int size = leftinfo.size + rightinfo.size+1;
        int min = Math.min(root.data, Math.min(leftinfo.min, rightinfo.min));
        int max = Math.max(root.data, Math.max(leftinfo.max, rightinfo.max));

        if (root.data <= leftinfo.max || root.data >= rightinfo.min) {
            return new info(false, size, min, max);
        }

        if (leftinfo.isbst && rightinfo.isbst) {
            maxbst = Math.max(maxbst, size);
            return new info(true, size, min, max);
        }
        return new info(false, size, min, max);
    }
    public static void main(String[] args) {
         /*
                    50
                   / \
                  30   60
                 /\    /\
                5  20 45  70
                          /\
                         65 80
            given bt 
         */

         Node root = new Node(50);
         root.left = new Node(30);
         root.left.left = new Node(5);
         root.left.right = new Node(20);
 
         root.right = new Node(60);
         root.right.left = new Node(45);
         root.right.right = new Node(70);
         root.right.right.left = new Node(65);
         root.right.right.right = new Node(80);

         /*
                    60
                   / \
                 45   70
                     /  \
                    65  80
                expected bst : size =5
         */
        largestbst(root);
        System.out.println("Size of the largest BST:" + maxbst);
    }
 }

