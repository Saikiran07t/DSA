class Solution {
    public int longestConsecutive(int[] nums) {
        int size=nums.length;
        int longestLength=0;
        Set<Integer> set = new TreeSet<>();
        //add all the elements to set
        for(int num : nums)
            set.add(num);
        
        
        for(int index=0;index<size;index++){
            int curElement = nums[index];
            int prevElement = curElement-1;
           
            if(!set.contains(prevElement)){
                 int curCount=1;
         // now iterate through set and find the consecutive no's
                while(set.contains(curElement+1)){
                    curElement++;
                    curCount++;
                }
                longestLength = Math.max(longestLength,curCount);
            }
        }
        return longestLength;
    }
}