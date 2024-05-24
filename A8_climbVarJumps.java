import java.util.*;
public class A8_climbVarJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        // recursion
        int ans = climb(0, n, arr);
        System.out.println(ans);

        // tabulation
    }

    public static int climb(int i, int n, int[] arr){
        if(i == n) return 1;
        if(i > n) return 0;

        int val = arr[i];
        int ans = 0;
        for(int j = 1; j <= val; j++){      //
            ans += climb(i+j, n, arr);
        }

        return ans;
    }
}
