//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
    //     // code here
    //     int n=N;
    //      int[][] dp=new int[n][W+1];
    
    // //Base Condition
    
    // for(int i=wt[0]; i<=W; i++){
    //     dp[0][i] = ((int) i/wt[0]) * val[0];
    // }
    
    // for(int ind =1; ind<n; ind++){
    //     for(int cap=0; cap<=W; cap++){
            
    //         int notTaken = 0 + dp[ind-1][cap];
            
    //         int taken = Integer.MIN_VALUE;
    //         if(wt[ind] <= cap)
    //             taken = val[ind] + dp[ind][cap - wt[ind]];
                
    //         dp[ind][cap] = Math.max(notTaken, taken);
    //     }
    // }
    
    // return dp[n-1][W];
    
    
           int n=N;
    int[][] dp = new int[n+1][W+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<W+1;j++){
                if(i==0 || j==0) dp[i][j]=0;
            }
        }
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1]<=j)
                    dp[i][j]=Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                else  dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][W];
    
    }
}