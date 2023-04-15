class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
          int n = piles.size();
        int dp[][] = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int coins = 0; coins <= k; coins++) {
                int currentSum = 0;
                for (int currentCoins = 0; currentCoins <= Math.min((int)piles.get(i - 1).size(), coins); currentCoins++) {
                    if (currentCoins > 0) {
                        currentSum += piles.get(i - 1).get(currentCoins - 1);
                    }
                    dp[i][coins] = Math.max(dp[i][coins], dp[i - 1][coins - currentCoins] + currentSum);
                }
            }
        }
        return dp[n][k];
        
        
        
        
        
        
        
        //Knapsack variation
      /*  int[] f = new int[k + 1];
        int sumN = 0;
        for (var pile : piles) {
            int n = pile.size();
            for (int i = 1; i < n; ++i) {
                pile.set(i, pile.get(i) + pile.get(i - 1));
            }

            sumN = Math.min(sumN + n, k); 
            for (int j = sumN; j > 0; --j) {
                for (int w = 0; w < Math.min(n, j); ++w) {
                    f[j] = Math.max(f[j], f[j - w - 1] + pile.get(w)); 
                }
            }
        }

        return f[k];*/
    }
}