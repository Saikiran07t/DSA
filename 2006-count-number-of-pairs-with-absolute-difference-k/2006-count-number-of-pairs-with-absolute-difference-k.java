class Solution {
    public int countKDifference(int[] nums, int k) {
        /* brute force
          int count = 0;
        for (int i = 0;i<nums.length;i++){
            for (int j = i+1;j<nums.length;j++)
                if (Math.abs(nums[j]-nums[i]) == k) count++;
        }
        return count;
       */ 
        
        //optimal Hashing
       /*  Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        
        for(int i = 0;i< nums.length;i++){
            if(map.containsKey(nums[i]-k)){
                res+= map.get(nums[i]-k);
            }
            if(map.containsKey(nums[i]+k)){
                res+= map.get(nums[i]+k);
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        return res;
        */
        
        //count sort
         int res = 0;
        int[] freq = new int[101];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }
        // for(int i=freq.length-1;i>=k;i--){
        for(int i=k+1;i<freq.length;i++){
            // if(freq[i]>0 && freq[i-k]>0){
                res+=freq[i]*freq[i-k];
            // }
        }
        return res;
    }
}