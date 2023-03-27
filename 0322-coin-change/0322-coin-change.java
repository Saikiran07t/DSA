class Solution {
    public int coinChange(int[] coins, int amount) {
        //indexes
    //    int n= coins.length;
    //     int[][] dp = new int[n][amount+1];
    //    for(int[] row: dp)
    //        Arrays.fill(row,-1);
    //    int result=helper(coins,n-1,amount,dp);

     int n= coins.length;
    //  int T=amount;
    //    int dp[][]=new int[n][T+1];
    // // tabulation
    //    for(int i=0;i<=amount;i++){
    //        if(i%coins[0]==0) dp[0][i]=i/coins[0];
    //        else dp[0][i]=(int)Math.pow(10,9);
    //    }

    //   //changing parameters=no of loops
    // for(int ind = 1; ind<n; ind++){
    //     for(int target = 0; target<=T; target++){
            
    //         int notTake = 0 + dp[ind-1][target];
    //         int take = (int)Math.pow(10,9);
    //         if(coins[ind]<=target)
    //             take = 1 + dp[ind][target - coins[ind]];
                
    //          dp[ind][target] = Math.min(notTake, take);
    //     }
    // }
    //    int result=dp[n-1][amount];
    //    if(result>=(int)Math.pow(10,9)) return -1;
    //    return result;

    // space optimisation
//       int prev[]=new int[T+1]; 
//     int cur[] =new int[T+1];
    
//     for(int i=0; i<=T; i++){
//         if(i%coins[0] == 0)  
//             prev[i] = i/coins[0];
//         else prev[i] = (int)Math.pow(10,9);
//     }
    
//     for(int ind = 1; ind<n; ind++){
//         for(int target = 0; target<=T; target++){
            
//             int notTake = 0 + prev[target];
//             int take = (int)Math.pow(10,9);
//             if(coins[ind]<=target)
//                 take = 1 + cur[target - coins[ind]];
                
//              cur[target] = Math.min(notTake, take);
//         }
//         prev = cur;
//     }
    
//     int ans = prev[T];
//     if(ans >=(int)Math.pow(10,9)) return -1;
//     return ans;
//     }
   //Memoization
    // public int helper(int[] coins,int n,int amount,int[][] dp){
         
    //     //base condition
    //     if(n==0){
    //         if(amount%coins[0]==0) return amount/coins[0];
    //         else    return (int)Math.pow(10,9);
    //     }
    //    if(dp[n][amount]!=-1) return dp[n][amount];
    //     //all paths
    //     int notTake =0+helper(coins,n-1,amount,dp);
    //     int take=(int)Math.pow(10,9);
    //     if(coins[n]<=amount)  take=1+helper(coins,n,amount-coins[n],dp);
    //     return dp[n][amount]=Math.min(notTake,take);

    // }
        
        //aditya verma dp
        
         // Your code goes here
      int [][] dp = new int[n + 1][amount + 1];

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
        
        for(int i = 1 ; i<n+1 ; i++){
            for(int j = 1 ; j<amount+1 ; j++){
                
                if(coins[i - 1] <= j){
                    dp[i][j] = Math.min( 1+ dp[i][j-coins[i-1]] , dp[i-1][j]); 
                }
                else
                    dp[i][j] = dp[i-1][j]; 
            }
        }

        if(dp[n][amount] > amount)       return -1 ;
        return dp[n][amount] ;
    }

}