package dp4;

public class editdistance {
    public static int editdistance(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];

        for (int i = 0; i<n+1; i++) {
            for (int j = 0; j<m+1; j++) {
                if(i == 0){
                        dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
             }
        }
            //bottom up
         for (int i = 1; i <n+1; i++) {
            for (int j = 1; j<m+1; j++) {
                 if (s1.charAt(i-1) == s2.charAt(j-1)) { //same
                         dp[i][j] = dp[i-1][j-1];
                 }else{//diff
                     int add = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1; 
                    int rep = dp[i-1][j-1]+1;
                   
                    dp[i][j] = Math.min(add, Math.min(del,rep));
                 }
            }
        }
          return dp[n][m];
    }
    
    public static void main(String[] args) {
        String s1 = "intention";
        String s2 = "execution"; 
        System.out.println(editdistance(s1, s2));
    }
}
