import java.util.*;
public class B6_coinchangecomb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int tar = sc.nextInt();

        // tabulation
        int[] dp = new int[tar+1];
        dp[0] = 1;
        for(int i = 0; i < arr.length; i++){            // coin
            int val = arr[i];
            for(int j = val; j < dp.length; j++){        // i
                int remAmt = j-val;
                dp[j] = dp[j] + dp[remAmt];
            }
        }
        System.out.println(dp[tar]);
    }    
}
