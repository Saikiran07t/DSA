class Solution {
    //memoisation
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int n=text1.length();
    //     int m=text2.length();
    //     int[][] dp = new int[n][m];
    //     for(int[] row: dp)
    //        Arrays.fill(row,-1);
    //     return helper(text1,text2,n-1,m-1,dp);
    // }

    // public int helper(String text1,String text2,int ind1,int ind2,int[][] dp){
    //     //base case
    //     if(ind1<0 || ind2<0) return 0;
    //     if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
    //    //matching
    //    if(text1.charAt(ind1)==text2.charAt(ind2)) {
    //         return 1+helper(text1,text2,ind1-1,ind2-1,dp);
    //    }
    //    else{
    //        return dp[ind1][ind2]=0+Math.max(helper(text1,text2,ind1-1,ind2,dp),helper(text1,text2,ind1,ind2-1,dp));
    //    }
    // }
  
//   public int longestCommonSubsequence(String text1, String text2) {
//       int n=text1.length();
//       int m=text2.length();
//       //shifting indexes to satisfy base case
//       int[][] dp = new int[n+1][m+1];

//       //base case
//       for(int i=0;i<=n;i++)   dp[i][0]=0;
//       for(int j=0;j<=m;j++)   dp[0][j]=0;

//       for(int i=1;i<=n;i++){
//           for(int j=1;j<=m;j++){
//               if(text1.charAt(i-1)==text2.charAt(j-1)) {
//                   dp[i][j]=1+dp[i-1][j-1];
//               }
//               else{
//                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
//               }

//           }
//       }
//        return dp[n][m];

    //space optimisation
//       int[] prev = new int[m+1];
//       int[] cur = new int[m+1];

//       //base case

//       for(int j=0;j<=m;j++)   prev[j]=0;

//       for(int i=1;i<=n;i++){
//           for(int j=1;j<=m;j++){
//               if(text1.charAt(i-1)==text2.charAt(j-1)) {
//                   cur[j]=1+prev[j-1];
//               }
//               else{
//                   cur[j]=Math.max(prev[j],cur[j-1]);
//               }
//           }
//           prev=cur;
//       }
//        return prev[m];        
//   }
      
      /*
      Aditya Verma DP 
      */
    static int[][] dp = new int[1001][1001]; //global declaration w.r.t constraints
 public int longestCommonSubsequence(String text1, String text2) {
      int n=text1.length();
      int m=text2.length();
     // int[][] dp = new int[n+1][m+1];
     // for(int[] row: dp)
     //     Arrays.fill(row,-1);
     // return helper(text1,text2,n,m);
     
     //space optimisation
    /* for(int i=0;i<n+1;i++) dp[i][0]=0;
     for(int j=0;j<m+1;j++) dp[0][j]=0;
     for(int i=1;i<n+1;i++){
         for(int j=1;j<m+1;j++){
             if(text1.charAt(i-1)==text2.charAt(j-1))
                 dp[i][j]= 1+dp[i-1][j-1];
             else
                 dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
         }
     }
     return dp[n][m];
  */
     //Space Optimised Aditya Verma DP
     int[] prev = new int[m+1];
     int[] cur = new int[m+1];
     for(int j=0;j<m+1;j++) prev[j]=0; // dp[0][j]=0 onlu first row is req
     for(int i=1;i<n+1;i++){
         for(int j=1;j<m+1;j++){
             if(text1.charAt(i-1)==text2.charAt(j-1))
                 cur[j]= 1+prev[j-1];
             else
                 cur[j]=Math.max(prev[j],cur[j-1]);
         }
         prev=cur.clone();
     }
     return prev[m];
     
 }
 
      
     //Recursive
// public int helper(String text1,String text2,int n,int m){
//     if(n==0 || m==0) return 0;
    
//      if(text1.charAt(n-1)== text2.charAt(m-1))
//           return 1+helper(text1,text2,n-1,m-1);
//      return Math.max(helper(text1,text2,n-1,m),
//                 helper(text1,text2,n,m-1));
 //}
     
    //Memoization
/* public int helper(String text1,String text2,int n,int m){
        if(n==0 || m==0) return 0;
       if(dp[n][m]!=-1) return dp[n][m];
       if(text1.charAt(n-1)== text2.charAt(m-1))
           return dp[n][m]=1+helper(text1,text2,n-1,m-1);
     return dp[n][m]=Math.max(helper(text1,text2,n-1,m),
                helper(text1,text2,n,m-1));
       }
*/
}