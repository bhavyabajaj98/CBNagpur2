import java.util.*;
public class B4_TSS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[sc.nextInt()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int tar = sc.nextInt();

        // tabulation
        Boolean[][] dp = new Boolean[arr.length+1][tar+1];
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(j == 0){
                    dp[i][j] = true;
                }
                else if(i == 0){
                    dp[i][j] = false;
                }
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
        System.out.println(dp[dp.length-1][dp[0].length-1]);    //dp[n][tar]

    }    
}
