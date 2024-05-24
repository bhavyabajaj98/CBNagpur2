import java.util.*;
public class C1_BinStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // recursive
        int[][] dp = new int[2][n+1];
        int ans = helper(1, n, dp);
        System.out.println(ans);
    }    

    public static int helper(int prev, int n, int[][] dp){
        if(n == 1){
            if(prev == 0) return 1;
            else return 2;
        }

        if(dp[prev][n] != 0) return dp[prev][n];        //

        int ans = 0;
        if(prev == 0){
            ans = helper(1, n-1, dp);
        }
        else{
            ans = helper(0, n-1, dp) + helper(1, n-1, dp);
        }

        dp[prev][n] = ans;
        return ans;
    }
}
