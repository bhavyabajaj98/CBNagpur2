import java.util.*;
public class Z1_coinChangePer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[sc.nextInt()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int tar = sc.nextInt();

        System.out.println(countPer(tar, arr, new Integer[tar+1]));

        // tabulation
        int[] dp = new int[tar+1];
        dp[0] = 1;
        for(int j = 1; j <= tar; j++){
            for(int val: arr){
                dp[j] += j-val >= 0 ? dp[j-val] : 0;
            }
        }
        System.out.println(dp[tar]);
    }    

    public static int countPer(int tar, int[] arr, Integer[] dp){
        if(tar == 0) return 1;
        if(tar < 0) return 0;
        if(dp[tar] != null) return dp[tar];

        int ans = 0;
        for(int val: arr){
            ans += countPer(tar-val, arr, dp);
        }
        return dp[tar] = ans;
    }
}
