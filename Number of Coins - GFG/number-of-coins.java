//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    int amount=V;
      int [][] dp = new int[coins.length + 1][amount + 1];

       // Initialization
        // for(int i = 0 ; i<=M ; i++){
        //     dp[i][0] = 0;
        // }
        
  //According to Aditya Verma instead of initializing first row with Int_MAX-1 and then filling second row 
  // based on if it is divisible by sum or not . We can directly check if it is divisible 
  //or else assign Int_Max in first row itself
        for(int j = 0; j<=amount ; j++){
        if(j%coins[0]==0)    dp[0][j]=j/coins[0];
        else                 dp[0][j] = (int)Math.pow(10,9);
        }
        
        for(int i = 1 ; i<M+1 ; i++){
            for(int j = 1 ; j<amount+1 ; j++){
                
                if(coins[i - 1] <= j){
                    dp[i][j] = Math.min( 1+ dp[i][j-coins[i-1]] , dp[i-1][j]); 
                }
                else
                    dp[i][j] = dp[i-1][j]; 
            }
        }

        if(dp[M][amount] > amount)       return -1 ;
        return dp[M][amount] ;

	} 
}