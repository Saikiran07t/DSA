class Solution {
    public String addBinary(String a, String b) {
      // First, create result name string and intially it is empty & in the end we gonna return it as our aswer
        StringBuilder res = new StringBuilder(); 
        int i = a.length() - 1; // we crete i pointer for string a and we have to start adding from right to left 
        int j = b.length() - 1; // similar pointer j for string b
        int carry = 0; // we create a carry, as we have to consider it as well
        
        // iterate over the loop until the both condition become false
        while(i >= 0 || j >= 0){ 
            int sum = carry; // intialise our sum with carry;
            
            // Now, we subtract by '0' to convert the numbers from a char type into an int, so we can perform operations on the numbers
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            // taking carry;
            carry = sum > 1 ? 1 : 0; // getting carry depend on the quotient we get by dividing sum / 2 that will be our carry. Carry could be either 1 or 0 
			// if sum is 0 res is 1 & then carry would be 0;
            // if sum is 1 res is 1 & carry would be 0
            // if sum is 2 res is 0 & carry would be 1
            // if sum is 3 res is 1 & carry would be 1
            res.append(sum % 2); // just moduling the sum so, we can get remainder and add it into our result
        }
        if(carry != 0) res.append(carry); // we gonna add it into res until carry becomes 0;
        return res.reverse().toString(); // revese the answer we get & convt to string and return by the help of result;
        
        //Approach -2 
      //  return new java.math.BigInteger(a, 2).add(new java.math.BigInteger(b, 2)).toString(2);
    }
}