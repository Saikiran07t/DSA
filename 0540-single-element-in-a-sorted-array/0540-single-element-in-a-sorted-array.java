class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        int lo=0,hi=nums.length-1;
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            if((mid%2==0 && nums[mid]==nums[mid+1]) || (mid%2==1 && nums[mid]==nums[mid-1])){
                lo=mid+1;
            }
            else hi=mid;
        }
        return nums[lo];
 //https://leetcode.com/problems/single-element-in-a-sorted-array/discuss/627921/Java-or-C%2B%2B-or-Python3-or-Easy-explanation-or-O(logn)-or-O(1)       
    }
}