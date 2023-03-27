class Solution {
    public int minPathSum(int[][] grid) {
        //space optimisation
        int n=grid.length;
        int m=grid[0].length;
        
//        int prev[] = new int[m];
//         for(int i=0;i<n;i++){
//             int cur[] = new int[m];
//             for(int j=0;j<m;j++){
                
//                 if(i==0 && j==0)  cur[j]=grid[0][0];
//                 else{
//                     int up=grid[i][j];
//                     if(i>0) up+=prev[j];
//                     else    up+=(int)Math.pow(10,9);
                    
//                     int left=grid[i][j];
//                     if(j>0) left+=cur[j-1];
//                     else left+=(int)Math.pow(10,9);
                    
//                     cur[j]=Math.min(up,left);
//                 }
//             }
//             prev=cur;
//         }
//         return prev[m-1];
        
        //Tabulation
        int[][] dp = new int[n][m];
          for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(i==0 && j==0)  dp[i][j]=grid[0][0];
                else{
                    int up=grid[i][j];
                    if(i>0) up+=dp[i-1][j];
                    else    up+=(int)Math.pow(10,9);
                    
                    int left=grid[i][j];
                    if(j>0) left+=dp[i][j-1];
                    else    left+=(int)Math.pow(10,9);
                    
                    dp[i][j]=Math.min(up,left);
                }
            }
        }
        return dp[n-1][m-1];        
    }
}