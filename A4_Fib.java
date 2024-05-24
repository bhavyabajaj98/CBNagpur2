import java.util.*;
public class A4_Fib {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        System.out.println(fib(n, dp));
    }    

    public static int fib(int n, int[] dp){
        if(n == 0 || n == 1) return n;
        if(dp[n] != 0) return dp[n];

        int ans = fib(n-1, dp) + fib(n-2, dp);
        dp[n] = ans;
        return dp[n];       // ans
    }
}
