import java.util.*;
public class A9_ClimbStairsVarJumps{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        //tabulation
        Integer[] dp = new Integer[n+1];
        dp[n] = 0;

        for(int i = n-1; i >= 0; i--){
            if(arr[i] != 0){
                int val = Integer.MAX_VALUE;
                for(int j = 1; j <= arr[i] && i+j <= n; j++){
                    if(dp[i+j] != null) val = Math.min(val, dp[i+j]);
                }

                if(val != Integer.MAX_VALUE){
                    dp[i] = val+1;
                }
            }
        }
        System.out.println(dp[0]);
    }
}