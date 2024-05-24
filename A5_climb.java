import java.util.*;
public class A5_climb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // System.out.println(climb(0, n));

        int[] dp = new int[n+1];
        System.out.println(climbMem(0, n, dp));

        // tabulation
        int[] dp1 = new int[n+1];
        dp1[n] = 1;
        for(int i = n-1; i >= 0; i--){
            dp1[i] = dp1[i+1] + (i+2 <= n ? dp1[i+2] : 0) + (i+3 <= n ? dp1[i+3] : 0);
        }
        System.out.println(dp1[0]);
    }    

    public static int climb(int i, int n){
        if(i == n) return 1;
        if(i > n) return 0;

        return climb(i+1, n) + climb(i+2, n) + climb(i+3, n);
    }

    public static int climbMem(int i, int n, int[] dp){
        if(i == n) return 1;
        if(i > n) return 0;
        if(dp[i] != 0) return dp[i];

        // System.out.println(i);

        dp[i] = climbMem(i+1, n, dp) + climbMem(i+2, n, dp) + climbMem(i+3, n, dp);
        return dp[i];
    }
}
