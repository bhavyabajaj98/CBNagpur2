import java.util.*;
public class A3_goldmine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[sc.nextInt()][sc.nextInt()];

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        // recursion
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, goldmine1(i, 0, arr));
        }
        System.out.println(max);

        // memoization
        max = Integer.MIN_VALUE;
        int[][] dp = new int[arr.length][arr[0].length];
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, goldmine2(i, 0, arr, dp));
        }
        System.out.println(max);

        // tabulation
        max = goldmine3(arr);
        System.out.println(max);
    }

    public static int goldmine3(int[][] arr){
        for(int j = arr[0].length-2; j >= 0; j--){
            for(int i = 0; i < arr.length; i++){
                arr[i][j] += Math.max(arr[i][j+1], Math.max(i-1 >= 0 ? arr[i-1][j+1] : 0, i+1 < arr.length ? arr[i+1][j+1] : 0));
            }
        }

        int ans = arr[0][0];
        for(int i = 1; i < arr.length; i++){
            ans = Math.max(ans, arr[i][0]);
        }

        return ans;
    }

    public static int goldmine1(int i, int j, int[][] arr){
        if(j == arr[0].length-1){       //
            return arr[i][j];
        }

        int max = goldmine1(i, j+1, arr);
        if(i-1 >= 0){
            max = Math.max(max, goldmine1(i-1, j+1, arr));
        }
        if(i+1 < arr.length){
            max = Math.max(max, goldmine1(i+1, j+1, arr));
        }
        return arr[i][j] + max;
    }

    public static int goldmine2(int i, int j, int[][] arr, int[][] dp){
        if(j == arr[0].length-1){       //
            return arr[i][j];
        }

        if(dp[i][j] != 0) return dp[i][j];

        int max = goldmine2(i, j+1, arr, dp);
        if(i-1 >= 0){
            max = Math.max(max, goldmine2(i-1, j+1, arr, dp));
        }
        if(i+1 < arr.length){
            max = Math.max(max, goldmine2(i+1, j+1, arr, dp));
        }


        return dp[i][j] = arr[i][j] + max;
    }
}
