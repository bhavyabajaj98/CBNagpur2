import java.util.*;
public class A2_climb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        // recursive approach
        int ans = climb1(0, n);

        // memoization
        int[] dp = new int[n+1];
        int ans1 = climb2(0, n, dp);
        System.out.println(ans);

        //tabulation
    }

    public static int climb1(int i, int n){
        if(i == n) return 1;
        if(i > n) return 0;

        return climb1(i+1, n) + climb1(i+2, n) + climb1(i+3, n);
    }

    public static int climb2(int i, int n, int[] dp){
        if(i == n) return 1;
        if(i > n) return 0;
        if(dp[n] != 0) return dp[n];

        int ans = climb2(i+1, n, dp) + climb2(i+2, n, dp) + climb2(i+3, n, dp);
        dp[i] = ans;
        return dp[i];
    }
}
