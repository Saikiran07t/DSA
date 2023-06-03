//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
   
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
         // int size=arr.length;
        //brute force gives TLE 
    //     int longestLength=0;
    //   for(int i=0;i<N;i++){
    //       int sum=0;
    //       for(int j=i;j<N;j++){ //starts from i to n
    //       /*
    //         for(int k=i;k<=j;k++)   k -> from i to j but this can be omitted as j starts from i and there would 
    //         be only one element to get added.
    //       */
    //           sum+=A[j];
    //           if(sum==K) longestLength=Math.max(longestLength,j-i+1); //j-i+1 is distance between i and j
    //       }
    //   }    
    //   return longestLength;
      
       
       //optimal using HashMap.
       //This is the optimal solution if array has +ve and -ve integers
      Map<Integer,Integer> map = new HashMap<>();
      int maxLength=0,prefixSum=0;
      for(int index=0;index<N;index++){
          prefixSum+=A[index];
          if(prefixSum==K)  maxLength=index+1; //as it is 0 based indexing so 
          else{
              if(map.containsKey(prefixSum-K)) { 
                  maxLength= Math.max(maxLength,index-map.get(prefixSum-K));//update max length with first occurance of prefixSum
              }
          }
          if(!map.containsKey(prefixSum))  map.put(prefixSum,index);
      }
      return maxLength;
    
    }
    
}


