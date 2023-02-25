class Solution {
    public int maxProfit(int[] prices) {
        //bruuteforce approach
      // int diff=0,profit=0;
      //   for(int i=0;i<prices.length;i++){
      //       for(int j=i+1;j<prices.length;j++){
      //           if(prices[i]<prices[j]){
      //               diff=prices[j]-prices[i];
      //           }
      // if(profit<diff){     //instead of two if condition use               profit=Math.max(diff,profit)
      //               profit=diff;
      //           }
      //       }
      //   }
      //   return profit;
        
        int maxProf=0,minPrice=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice)  minPrice=prices[i];
            if(prices[i]-minPrice>maxProf) maxProf=prices[i]-minPrice;
        }
        return maxProf;
    }
}