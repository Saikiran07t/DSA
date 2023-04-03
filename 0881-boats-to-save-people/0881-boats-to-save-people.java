class Solution {
    
    /*
    Approach
Sort the people array in non-decreasing order.

Initialize the left pointer to the first element of the array, and the right pointer to the last element of the array.

Initialize a counter variable boats to 0.

While the left pointer is less than or equal to the right pointer, do the following:
a. Check if the sum of the weights of the people at the left and right pointers is less than
or equal to the limit.
b. If the sum is less than or equal to the limit, move the left pointer one step to the
right to include the next lightest person.
c. Move the right pointer one step to the left to include the next heaviest person,
regardless of whether or not they can fit on the current boat.
d. Increment the boats counter by 1.

Return the boats counter, which represents the total number of boats used.
    
    */
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