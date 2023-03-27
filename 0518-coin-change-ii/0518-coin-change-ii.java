class Solution {
    public int change(int amount, int[] coins) {
       // int n=coins.length;
        // int[][] dp = new int[n][amount+1];
        // for(int[] row : dp)  Arrays.fill(row,-1);
        // return helper(coins,n-1,amount,dp);

        //tabulation
        // for(int target=0;target<=amount;target++){
        //     if(target%coins[0]==0) dp[0][target]=1;
        //     else                  dp[0][target]=0;

        // }

        // for(int ind=1;ind<n;ind++){
        //     for(int target=0;target<=amount;target++){
        //         int notTake=dp[ind-1][target];
        //         int take=0;
        //         if(coins[ind]<=target)
        //             take=dp[ind][target-coins[ind]];
        //         dp[ind][target]=take+notTake;
        //     }
        // }
        // return dp[n-1][amount];
 
        //space optimisation
//          int[] prev = new int[amount+1];
//          int[] cur = new int[amount+1];
//           for(int target=0;target<=amount;target++){
//             if(target%coins[0]==0) prev[target]=1;
//             else                  prev[target]=0;

//         }

//         for(int ind=1;ind<n;ind++){
//             for(int target=0;target<=amount;target++){
//                 int notTake=prev[target];
//                 int take=0;
//                 if(coins[ind]<=target)
//                     take=cur[target-coins[ind]];
//                 cur[target]=take+notTake;
//             }
//             prev=cur;
//         }
//         return prev[amount];
//    }
 //memoization
// public int helper(int[] coins,int ind,int target,int[][] dp){
//     //base case
//     if(ind==0){
//         return (target%coins[0]==0?1:0);
//     }
//     if(dp[ind][target]!=-1) return dp[ind][target];
//     int notTake=helper(coins,ind-1,target,dp);
//     int take=0;
//     if(coins[ind]<=target) take=helper(coins,ind,target-coins[ind],dp);

//     return dp[ind][target]=take+notTake;
// }
        
        int n=coins.length;
        int[][] dp= new int[n+1][amount+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<amount+1;j++){
                if(i==0) dp[i][j]=0;
                if(j==0) dp[i][j]=1;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                if(coins[i-1]<=j){
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }

}