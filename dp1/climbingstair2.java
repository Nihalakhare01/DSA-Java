package dp1;

import java.util.Arrays;

//  climbing stair memorization dp
public class climbingstair2 { //o(n)
    public static int count(int n, int ways[]){
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if ( ways[n] != -1) { //already calculated
            return ways[n];
        }
        ways[n] = count(n-1,ways) + count(n-2,ways);
        return ways[n];
    }

    public static void main(String[] args) {
        int n=5; //n=3 -> 3& n=4 -> 5 =>8
        int ways[] = new int[n+1]; 
        Arrays.fill(ways, -1);
        System.out.println(count(n,ways));
    }
}
