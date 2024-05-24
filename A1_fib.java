import java.util.*;
public class A1_fib{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        int ans = Fib(n, dp);
        System.out.println(ans);
    }

    public static int Fib(int n, int[] dp){
        if(n == 0 || n == 1) return n;
        if(dp[n] != 0) return dp[n];

        System.out.println(n);

        int ans = Fib(n-1, dp) + Fib(n-2, dp);
        dp[n] = ans;
        return ans;
    }

}