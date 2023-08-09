class Solution {
    public String longestPalindrome(String s) {
        //DP SOLUTION WITH O(N^2) TIME & SPACE COMPLEXITIES
//         if (s == null || "".equals(s)) {
//             return s;
//         }
        
//         int len = s.length();

//         String ans = "";
//         int max = 0;

//         boolean[][] dp = new boolean[len][len];

//         for (int j = 0; j < len; j++) {
            
//             for (int i = 0; i <= j; i++) {
                
//                 boolean judge = s.charAt(i) == s.charAt(j);
                
//                 dp[i][j] = j - i > 2 ? dp[i + 1][j - 1] && judge : judge;

//                 if (dp[i][j] && j - i + 1 > max) {
//                     max = j - i + 1;
//                     ans = s.substring(i, j + 1);
//                 }
//             }
//         }
//         return ans;
        
        //m-2 optimised
       if(s==null || s.length()<1) return "";
        int curMax=0;
        String curMaxString="";
        int length=s.length();
        for(int i=0;i<length;i++){
            int left=i;
            int right=i;//for odd length palindrome
            while(left>=0 && right<length && s.charAt(left)==s.charAt(right)){
                if(right-left+1>curMax){
                    curMax=right-left+1;
                    curMaxString =s.substring(left,right+1); 
                }
                left--;
                right++;
            }
            left=i;right=i+1; //for even length palindrome
            while(left>=0 && right<length && s.charAt(left)==s.charAt(right)){
                 if(right-left+1>curMax){
                    curMax=right-left+1;
                    curMaxString =s.substring(left,right+1); 
            }
            left--;
            right++;
        }
     }
        return curMaxString;
    }
    
}