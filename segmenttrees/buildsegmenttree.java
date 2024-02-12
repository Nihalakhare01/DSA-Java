package segmenttrees;

public class buildsegmenttree {
    static int tree[];

    
    public static void init(int n){
        tree = new int[4*n]; 
    }

    //creation of st
    public static int buildst(int arr[], int i, int start, int end){
        if (start == end) {
            tree[i] = arr[start];
            return arr[start];
        }

        int mid = (start+end)/2;
        buildst(arr, 2*i+1, start, mid); //left subtree - 2*i+1
        buildst(arr, 2*i+2, mid+1, end); //right subtree - 2*i+2
        tree[i] = tree[2*i+1] + tree[2*i+2];
        return tree[i];
    }

    //Query on st
    //sum of numbers in a range

    public static int getsumutil(int i, int si, int sj, int qi, int qj){  //O(log n)
            if (qj <= si || qi >= sj) { //non overlapping
                return 0;
            }else if (si >= qi && sj <= qj) { //complete overlap
                return tree[i];
            }else{ //partial overlap
                int mid = (si+sj)/2;
                int left = getsumutil(2*i+1, si, mid, qi, qj);
                int right = getsumutil(2*i+2, mid+1, sj, qi, qj);
                return left + right;
            }
        }

    public static int getsum(int arr[], int qi, int qj){
            int n = arr.length;
            return getsumutil(0, 0, n-1, qi, qj);
    }

    public static void updateutil(int i, int si, int sj, int idx, int diff){ //O(log n)
            if (idx > sj || idx < si) {
                return;
            }

            tree[i] += diff;
            if (si != sj) {     //non-leaf
                int mid = (si + sj)/2;
                updateutil(2*i+1, si, mid, idx, diff);     //left
                updateutil(2*i+2, mid+1, sj, idx, diff);  //right
            }
        }

    public static void update(int arr[], int idx, int newval){
        int n = arr.length;
        int diff = newval - arr[idx];
        arr[idx] = newval;

        updateutil(0, 0, n-1, idx, diff); //segment tree updation
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        init(n);
        buildst(arr, 0, 0, n-1);

        // for(int i=0; i<tree.length; i++){
        //     System.out.print(tree[i]+" ");
        // }

        System.out.println(getsum(arr, 2, 5));//18
        update(arr, 2, 2);
        System.out.println(getsum(arr, 2, 5));//17
    }
}
