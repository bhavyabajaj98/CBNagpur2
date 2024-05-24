import java.util.*;
import java.lang.*;
import java.io.*;

class Z2_Knapsack
{
    // 0-1 knapsack
	public static void main (String[] args) throws java.lang.Exception
	{
	    
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
	    int[] a = new int[n];
	    
	    for(int i=0;i<n;i++)
	    a[i]=scn.nextInt();
	    
	    int[] val = new int[n];
	    
	    for(int i=0;i<n;i++)
	    val[i]=scn.nextInt();
	    
	    int cap = scn.nextInt();
	    
	   // int[][] dp = new int[cap+1][a.length+1];
	    
	   // for(int i=0;i<dp.length;i++){
	   //     for(int j=0;j<dp[0].length;j++){
	   //         if(i==0 || j==0)
	   //         dp[i][j]=0;
	   //         else{
	   //             if(j-a[i-1]>=0){
	   //                 dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-a[i-1]]+val[i-1]);
	   //             }
	   //             else{
	   //                 dp[i][j]=dp[i-1][j];
	   //             }
	   //         }
	   //     }
	   // }
	    
	   // System.out.println(dp[a.length][cap]);
	    
	    Integer[][] dp2  =new Integer[cap+1][a.length+1];
	    int ans = knapsack(a,val,0,0,0,cap,dp2);
	    System.out.println(ans);

	}
	
	
	public static int knapsack(int[] a,int[] val,int sum_wt,int sum_val,int i,int cap,Integer[][] dp2){
        if(sum_wt==cap)
	        return 0;
        if(sum_wt > cap){
            return Integer.MIN_VALUE;
        }
        
        if(i==a.length){
            return 0;
	    }
	    
	    if(dp2[cap-sum_wt][i]!=null)
	        return dp2[cap-sum_wt][i];
	    
        int k2 = knapsack(a,val,sum_wt,sum_val,i+1,cap,dp2);
        k2 = Math.max(k2, val[i]+knapsack(a,val,sum_wt+a[i],sum_val+val[i],i+1,cap,dp2));
	    
	    
	    dp2[cap-sum_wt][i]=k2;
	    return k2;
	}
	
	
	
	
}