//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().getPairsCount(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        // code here
        int countOfPairs=0;
        Map<Integer,Integer> hmap = new HashMap<>();
        int size=n;
        for(int index=0;index<size;index++){
               if(hmap.containsKey(k-arr[index])) {
                countOfPairs+=hmap.get(k-arr[index]);
            }
            // if same element is found increment frequency
          if(hmap.containsKey(arr[index]))  hmap.put(arr[index],hmap.get(arr[index])+1);  
         
            else     hmap.put(arr[index],1);
        }
        return countOfPairs;
    }
}
