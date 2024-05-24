import java.util.*;
public class B8_coinchangePer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[sc.nextInt()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        int tar = sc.nextInt();

        //tabulation
        int[] dp = new int[tar+1];
        dp[0] = 1;
        for(int j = 1; j <= tar; j++){
            for(int i = 0; i < arr.length; i++){
                int val = arr[i];
                if(j-val >= 0) dp[j] += dp[j-val];
            }
        }
        System.out.println(dp[tar]);

        // recursion
        int[] dp1 = new int[tar+1];
        int ans = helper(tar, arr, dp1);
        System.out.println(ans);
    }

    public static int helper(int tar, int[] arr, int[] dp){
        if(tar == 0) return 1;
        if(tar < 0) return 0;

        if(dp[tar] != 0) return dp[tar];

        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            int val = arr[i];
            int remAmt = tar-val;
            ans += helper(remAmt, arr, dp);
        }

        dp[tar] = ans;
        return ans;
    }

    
}
