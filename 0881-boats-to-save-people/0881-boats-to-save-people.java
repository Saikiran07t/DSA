class Solution {
    public int numRescueBoats(int[] people, int limit) {
         int boatCount = 0;
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            int sum = people[left] + people[right];
            if(sum <= limit){
                boatCount++;
                left++;
                right--;
            }
            else{
                boatCount++;
                right--;
            }
        }
        return boatCount;
    }
    //T.C : O(N*Log N) Log N for sorting and there are N people
    //S.C : O(1)
}