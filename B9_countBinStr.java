import java.util.*;
public class B9_countBinStr{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] dp = new int[2][n+1];
        int ans = helper(n, 1, dp);
        System.out.println(ans);
    }

    public static int helper(int n, int prev, int[][] dp){
        if(n == 1){
            if(prev == 0) return 1;
            
            return 2;
        }
        if(dp[prev][n] != 0) return dp[prev][n];

        
        int ans = 0;
        if(prev == 0){
            ans = helper(1, n-1, dp);
        }
        else{           // 1
            ans = helper(0, n-1, dp) + helper(1, n-1, dp);
        }

        dp[prev][n] = ans;
        return ans;
    }
}