package dp1;
//recursion 
public class climbingstair {  // recursion(2*n) -> n =10
    public static int count(int n){
        if (n== 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return count(n-1) + count(n-2);
    }
    public static void main(String[] args) {
        int n=5;
        System.out.println(count(n));
    }
}
