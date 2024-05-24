import java.util.*;
public class A7_climb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // int[] dp = new int[n+1];
        // int ans = climb(0, n, dp);
        // System.out.println(ans);

        // tabulation
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i = n-1; i >= 0; i--){
            if(i == n-1){
                dp[i] = dp[i+1];
            }
            else if(i == n-2){
                dp[i] = dp[i+1] + dp[i+2];
            }
            else{
                dp[i] = dp[i+1] + dp[i+2] + dp[i+3];
            }
        }
        System.out.println(dp[0]);

    }

    public static int climb(int i, int n, int[] dp){
        if(i == n) return 1;
        if(i > n) return 0;
        if(dp[i] != 0) return dp[i];

        int ans = climb(i+1, n, dp) + climb(i+2, n, dp) + climb(i+3, n, dp);
        dp[i] = ans;
        return ans;
    }
}
