class Solution {
    public int countOdds(int low, int high) {
        
         //total numbers 
        int total= high-low+1;
        
        /* When low is odd and high is odd */
        if (low % 2 != 0 && high % 2 != 0) {
            return total/2 + 1;
        }
        else
            return total/2;    
        
      // 2 lines code approach
     //    int count = (high - low) / 2;
     // return (low % 2 == 1 || high % 2 == 1) ? count+=1 : count;
    }
}