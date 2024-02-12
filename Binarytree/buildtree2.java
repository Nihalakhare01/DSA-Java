package Binarytree;

import java.util.*;


public class buildtree2 {
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

    static class Info {
        Node node;
        int hd;
        
        public Info(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }  
    }

    public static void topview(Node root){
        //level order
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();

        int min = 0, max =0;
        q.add(new Info(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if(curr == null){
                if (q.isEmpty()) {
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if (!map.containsKey(curr.hd)) {//first time my hd is occuring
                map.put(curr.hd, curr.node);
            }

            if (curr.node.left != null) {
                q.add(new Info(curr.node.left, curr.hd-1));
                min = Math.min(min, curr.hd-1);
            }
            if (curr.node.right != null) {
                q.add(new Info(curr.node.right, curr.hd+1));
                max = Math.max(min, curr.hd+1);
            }
            }
        }

        for(int i=min; i<=max; i++){
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }

    public static void klevel(Node root,int level, int k){
        if(root == null) {
            return;
        }
        if(level == k){
            System.out.print(root.data+" ");
            return;
        }

        klevel(root.left, level+1, k);
        klevel(root.right, level+1, k);
    }
    
    public static boolean getpath(Node root, int n, ArrayList<Node> path){
        if (root == null) {
            return false;
        }

        path.add(root);

        if(root.data == n){
            return true;
        }

        boolean foundleft = getpath(root.left, n, path);
        boolean foundright = getpath(root.right, n, path);

        if (foundleft || foundright) {
            return true;   
        }

        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2){//lowest common ancestor 0(n)
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getpath(root, n1, path1);
            getpath(root, n2, path2);

            //last common ancestor

            int i=0;
            for(; i<path1.size() && i<path2.size(); i++){
                if (path1.get(i) != path2.get(i)) {
                    break;
                }
            }
                //last equal node-> i-1th
                Node lca = path1.get(i-1);
                return lca;
    }

       public static Node lca2(Node root, int n1, int n2){
            if(root == null || root.data == n1 || root.data == n2){
                return root;
            }
            Node leftlca = lca2(root.left, n1, n2);
            Node rightlca = lca2(root.right, n1, n2);

            //leftlca=val rightlca= null
            if (rightlca == null) {
                return leftlca;
            }
             if (leftlca == null) {
                return rightlca;
            }
            return root;
       }

       public static int lcadist(Node root, int n){
        if(root == null){
            return -1;
        }

        if(root.data == n){
             return 0;
        }

        int leftdist = lcadist(root.left, n);
        int rightdist = lcadist(root.right, n);

        if (leftdist == -1 && rightdist == -1) {
            return -1;
        }else if (leftdist == -1) {
            return rightdist+1;
        }else{
            return leftdist+1;
        }
       }

       public static int mindist(Node root, int n1, int n2){
        Node lca = lca2(root, n1, n2);
        int dist1 = lcadist(lca, n1);
        int dist2 = lcadist(lca,n2);

        return dist1+dist2;
       }

       public static int kancestor(Node root, int n, int k){
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftdist = kancestor(root.left, n, k);
        int rightdist = kancestor(root.right, n, k);

        if (leftdist == -1 && rightdist == -1) {
            return -1;
        }

        int max = Math.max(leftdist, rightdist);

        if (max+1 == k) {
            System.out.println(root.data);
        }
        return max+1;
       }

       public static int transform(Node root){
            if(root == null){
                return 0;
            }
            int leftchild = transform(root.left);
            int rightchild = transform(root.right);

            int data = root.data;

            int newleft = root.left == null ? 0 : root.left.data;
            int newright = root.right == null ? 0: root.right.data;

            root.data = newleft + leftchild + newright + rightchild;
            return data;
       }

       public static void preorder(Node root){
        if (root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
       }

    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 /\   /\
                4  5 6  7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // System.out.println("topview of tree");
        // topview(root);
        // System.out.println("kth level of tree");
        // klevel(root, 1, 3);
        // int n1=4, n2=5;
        // System.out.println(lca(root,n1,n2).data);
        // int n1=4, n2=6;
        // System.out.println(lca2(root,n1,n2).data);
        // System.out.println(mindist(root, n1, n2));
    //    int n=5, k=1;
    //    kancestor(root, n, k);
        transform(root);
        preorder(root);
    }
}
