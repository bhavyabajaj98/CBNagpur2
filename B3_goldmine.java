import java.util.*;
public class B3_goldmine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        // tabulation
        int[][] dp = new int[arr.length][arr[0].length];
        for(int j = dp[0].length-1; j >= 0; j--){
            for(int i = 0; i < dp.length; i++){
                // c1
                if(j == dp[0].length-1){
                    dp[i][j] = arr[i][j];
                }
                // c2
                else if(i == dp.length-1){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
                }
                // c3
                else if(i == 0){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
                }
                // c4
                else{
                    int max = dp[i][j+1];
                    if(dp[i-1][j+1] > max){
                        max = dp[i-1][j+1];
                    }
                    if(dp[i+1][j+1] > max){
                        max = dp[i+1][j+1];
                    }
                    dp[i][j] = arr[i][j] + max;
                }
            }
        }

        int ans = dp[0][0];
        for(int i = 1; i < dp.length; i++){
            ans = Math.max(ans, dp[i][0]);
        }
        System.out.println(ans);
    }    
}
