 package binarysearchtree;

import java.util.ArrayList;

public class buildbst {
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
    public static Node insert(Node root, int val){
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data>val) {
            //left subtree
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root){
        if (root == null) {
            return;
        }
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }
        if (root.data>key) {
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val){
        if (root.data<val) {
            root.right = delete(root.right, val);
        }else if(root.data > val){
            root.left = delete(root.left, val);
        }else{//voila
            //case1: leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
                //case2: single child
            if (root.left == null) {
                return root.right;
            }else if (root.right == null) {
                return root.left;
            }
            //case3 : both children
            Node is = findinordersuccessor(root.right);
            root.data = is.data;
            root.right = delete(root.right, is.data);
        }
        return root;
    }

    public static Node findinordersuccessor(Node root){
        while(root.left !=null){
                root = root.left;
        }
        return root;
    } 
    
    public static void printinrange(Node root,int k1, int k2){
        if (root == null) {
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printinrange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printinrange(root.right, k1, k2);
        }else if (root.data<k1) {
            printinrange(root.left, k1, k2);
        }else {
            printinrange(root.right, k1, k2);
        }
    }

    public static void printpath(ArrayList<Integer> path){
        for (int i=0 ;i < path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }
    public static void printroot2leaf(Node root, ArrayList<Integer> path){
        if (root == null) {
            return;
        }

        path.add(root.data);
        if (root.left == null && root.right == null) {
            printpath(path);
        }

        printroot2leaf(root.left, path);
        printroot2leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isvalidbst(Node root, Node min, Node max){
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        }else if (max != null && root.data >= max.data) {
            return false;
        }
         return isvalidbst(root.left, min, root) && isvalidbst(root.right, root, max);
    }
       
    
    public static void main(String[] args) {
        int values[] = {8,5,3,6,10,11,14};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);  
        }
        inorder(root);
        System.out.println();
        
            //key =9 
        // if (search(root, 9)) {
        //     System.out.println("found");
        // }else{
        //     System.out.println("not found");
        // }

        // root = delete(root, 4);
        // System.out.println();

        // inorder(root);
        // System.out.println();

        //  printinrange(root, 4, 12);
       
        // printroot2leaf(root,new ArrayList<>());

        if(isvalidbst(root, null, null)){
            System.out.println("valid");
        }else{
            System.out.println("not valid");
        }
    }
}