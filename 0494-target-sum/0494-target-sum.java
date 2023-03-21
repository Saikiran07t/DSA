class Solution {
    // public int findTargetSumWays(int[] nums, int target) {
    //     int n=nums.length;
        // int totSum=0;
        // for(int i=0;i<n;i++)  totSum+=nums[i];

        // //edge cases
        // if(totSum-target<0) return 0;
        // if((totSum-target)%2==1) return 0;
        // int s2=(totSum-target)/2;
        // int[][] dp = new int[n][s2+1];

        // for(int[] row:dp)  Arrays.fill(row,-1);

        // return helper(n-1,s2,nums,dp);


        //tabulation  //not working correctly
        //  int[][] dp = new int[n][target+1];
        //  if(nums[0]==0) dp[0][0]=2;//pick & not pick
        //  else dp[0][0]=1;//not pick case

        //  if(nums[0]!=0 && nums[0]<=target) dp[0][nums[0]]=1; // we can pick it
        //  for(int ind=1;ind<n;ind++){
        //      for(int tar=0;tar<=target;tar++){
        //          int notTake=dp[ind-1][tar];
        //          int take=0;
        //          if(nums[ind]<=tar) take=dp[ind-1][tar-nums[ind]];
        //          dp[ind][tar]=take+notTake;
        //      }
        //  }
        //  return dp[n-1][target];

        //another top down approach -working fine
    //      if(n==1){
    //         if(target<0 && Math.abs(target)!=Math.abs(nums[0])) return 0;
    //     }
    //     int S=target;
    //    int sum=0;
    //     for(int i=0;i<nums.length;i++){
    //         sum+=nums[i];
    //     }
    //     // if netsum<target or if newS is not even since all nums are integer return 0
    //     if(sum<S || (S+sum)%2 !=0){
    //         return 0;
    //     }
    //     int newS=(S+sum)/2;
    //     // finding subsets which have sum=newS
    //     int dp[]=new int[newS+1];
    //    // for sum ==0 we have 1 way dont take any element
    //     dp[0]=1;
    //     // rest all 0 prefellid
    //     // top down dp
    //     for(int i=0;i<nums.length;i++){
    //         // j reprents target sum
    //         for(int j=newS;j>=nums[i];j--){
    //             // adding already present ways to the ways if we take that nums[i]
    //             dp[j]=dp[j]+dp[j-nums[i]];
    //         }
    //     }
    //     return dp[newS];
    // }
   //space optimisation -not working

    // int prev[]=new int[target+1];
    
    // if(nums[0] == 0) prev[0] =2;  // 2 cases -pick and not pick
    // else prev[0] = 1;  // 1 case - not pick
    
    // if(nums[0]!=0 && nums[0]<=target) prev[nums[0]] = 1;  // 1 case -pick
    
    // for(int ind = 1; ind<n; ind++){
    //     int cur[]=new int[target+1];
    //     for(int tar= 0; tar<=target; tar++){
    //         int notTaken = prev[tar];
    
    //         int taken = 0;
    //             if(nums[ind]<=tar)
    //                 taken = prev[tar-nums[ind]];
        
    //         cur[tar]= (notTaken + taken);
    //     }
    //     prev = cur;
    // }
    // return prev[target];
    //}

//    public int helper(int ind,int target,int[] nums,int[][] dp){
//        //base case
//        if(ind==0){
//            if(target==0 && nums[0]==0) return 2;
//            if(target==0 || target==nums[0]) return 1;
//            return 0;
//        }

//        if(dp[ind][target]!=-1) return dp[ind][target];
//        int notTake=helper(ind-1,target,nums,dp);
//        int take=0;
//        if(nums[ind]<=target) take=helper(ind-1,target-nums[ind],nums,dp);
//        return dp[ind][target]=take+notTake;
//    }
    
    
    //Aditya Verma DP Code
     static int M=  (int)(Math.pow(10,9)+7);
	public int findTargetSumWays(int[] nums,int target) {
		// Write your code here.
		int arrSum=0;
		for(int num : nums)
		    arrSum+=num;
            //edge cases
		int tar=(arrSum+target)/2;
		if(arrSum+target<0) return 0;
		if((arrSum+target)%2==1) return 0;
		return findTargetSumWaysHelper(nums,tar);
	}

	 public static int findTargetSumWaysHelper(int nums[], int target) {
        // Write your code here..
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        // count zeros
        int countZeros=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0) countZeros++;
        }
        //initialization of base condition
        for(int i=0;i<n+1;i++){
            for(int j=0;j<target+1;j++){
                if(i==0) dp[i][j]=0;
                if(j==0) dp[i][j]=1;

            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=0;j<target+1;j++){ //
                if(nums[i-1]<=j){
                    dp[i][j]=(dp[i-1][j-nums[i-1]] %M+dp[i-1][j]%M)%M;
                }
              //  if(num[i-1]>j || num[i-1]==0)  dp[i][j]=dp[i-1][j]%M;
              else  dp[i][j]=dp[i-1][j]%M;
            }
        }
        return dp[n][target];
     //  return (int)Math.pow(2,countZeros)*dp[n][tar];
}



}