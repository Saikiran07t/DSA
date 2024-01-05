class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
    //    int n= arr.length;
    //     int dp[][]=new int[n][n+1];
    // for(int row[]: dp)
    // Arrays.fill(row,-1);
    
    // return getAns(nums,n,0,-1,dp);

    //tabulation
    //  int dp[][]=new int[n+1][n+1];
    
    // for(int ind = n-1; ind>=0; ind --){
    //     for (int prev_index = ind-1; prev_index >=-1; prev_index --){
            
    //         int notTake = 0 + dp[ind+1][prev_index +1];
    
    //         int take = 0;
    
    //         if(prev_index == -1 || arr[ind] > arr[prev_index]){
                
    //             take = 1 + dp[ind+1][ind+1];
    //         }
    
    //         dp[ind][prev_index+1] = Math.max(notTake,take);
            
    //     }
    // }
    
    // return dp[0][0];

    //space optimisation
    //   int next[]=new int[n+1];
    // int cur[]=new int[n+1];
    
    // for(int ind = n-1; ind>=0; ind --){
    //     for (int prev_index = ind-1; prev_index >=-1; prev_index --){
            
    //         int notTake = 0 + next[prev_index +1];
    
    //         int take = 0;
    
    //         if(prev_index == -1 || arr[ind] > arr[prev_index]){
                
    //             take = 1 + next[ind+1];
    //         }
    
    //         cur[prev_index+1] = Math.max(notTake,take);
    //     }
    //     next = cur.clone();
    // }
    
    // return next[0];  //i.e next[-1+1]

   //lis with binary search
     TreeSet<Integer> ts = new TreeSet<>();
        ts.add(nums[0]);
        
        for(int i=1; i<nums.length; i++){
            if(nums[i] < ts.last()){
                int next = ts.ceiling(nums[i]);
                ts.remove(next);
            }
            ts.add(nums[i]);
        }

        return ts.size();

    }

//     public int getAns(int arr[], int n,  int ind, int prev_index,int[][] dp){
    
//     // base condition
//     if(ind == n)
//         return 0;
        
//     if(dp[ind][prev_index+1]!=-1)
//         return dp[ind][prev_index+1];
    
//     int notTake = 0 + getAns(arr,n,ind+1,prev_index,dp);
    
//     int take = 0;
    
//     if(prev_index == -1 || arr[ind] > arr[prev_index]){
//         take = 1 + getAns(arr,n,ind+1,ind,dp);
//     }
    
//     return dp[ind][prev_index+1] = Math.max(notTake,take);
// }
}