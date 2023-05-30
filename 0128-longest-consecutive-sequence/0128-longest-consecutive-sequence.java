class Solution {
    public int longestConsecutive(int[] nums) {
        //optimal
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        int longestLength=0;
        for(int num : nums){
            if(!set.contains(num-1)){
                int curNum=num;
                int curCount=1;
                // now iterate through set and find the consecutive no's
                while(set.contains(curNum+1)){
                    curNum+=1;
                     curCount+=1;
                }
                longestLength=Math.max(longestLength,curCount);
            }
        }
        return longestLength;
    }
}