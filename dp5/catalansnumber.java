package dp5;

import java.util.Arrays;

public class catalansnumber {
    //method -recursion
    public static int catalansrec(int n){
            if (n == 0 || n==1) {
                return 1;
            }
        int ans =0; //Cn
        for(int i=0; i<=n-1; i++){
            ans += catalansrec(i)*catalansrec(n-i-1);
        }
        return ans;
    }

    //memoization
    public static int catalanmem(int n, int dp[]){
         if (n == 0 || n==1) {
                return 1;
            }

            if (dp[n] != -1) {
                return dp[n];
            }

        int ans =0; //Cn
        for(int i=0; i<n; i++){
            ans += catalanmem(i,dp)*catalanmem(n-i-1,dp);
        }
        return dp[n] = ans;
    }

    //tabulation
    //O(n*n)
    public static int catalantab(int n){
        int dp[] = new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    } 

    public static void main(String[] args) {
        // int n=10;
        // System.out.println(catalansrec(n));


        // int dp[] = new int[n+1];
        // Arrays.fill(dp, -1);
        // System.out.println(catalanmem(4, dp));

        System.out.println(catalantab(5));
    }
}
