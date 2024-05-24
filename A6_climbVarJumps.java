import java.util.*;
public class A6_climbVarJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        // recursion
        System.out.println(climb(0, n, arr));

        // memoization : try yourself

        // tabulation
        int[] dp = new int[n+1];
        dp[n] = 1;
        for(int i = n-1; i >= 0; i--){
            int val = arr[i];
            for(int j = 1; j <= val && i+j <= n; j++){
                 dp[i] += dp[i+j];
            }
        }
        System.out.println(dp[0]);
    }    

    public static int climb(int i, int n, int[] arr){
        if(i == n) return 1;
        if(i > n) return 0;

        int ans = 0;
        for(int j = 1; j <= arr[i]; j++){
            ans += climb(i+j, n, arr);
        }

        return ans;
    }
}
