import java.util.*;
public class B5_TSS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int tar = sc.nextInt();

        // tabulation
        boolean[][] dp = new boolean[arr.length+1][tar+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                // c1
                if(j == 0){
                    dp[i][j] = true;
                }
                // c2
                else if(i == 0){
                    dp[i][j] = false;
                }
                // c3
                else{
                    int val = arr[i-1];
                    if(j < val){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-val];
                    }
                }
            }
        }
        System.out.println(dp[arr.length][tar]);
    }    
}
