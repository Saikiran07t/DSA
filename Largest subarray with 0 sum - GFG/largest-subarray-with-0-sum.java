//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        // int size=arr.length;
        //brute force gives TLE 
    //     int longestLength=0;
    //   for(int i=0;i<n;i++){
    //       int sum=0;
    //       for(int j=i;j<n;j++){ //starts from i to n
    //       /*
    //         for(int k=i;k<=j;k++)   k -> from i to j but this can be omitted as j starts from i and there would 
    //         be only one element to get added.
    //       */
    //           sum+=arr[j];
    //           if(sum==0) longestLength=Math.max(longestLength,j-i+1); //j-i+1 is distance between i and j
    //       }
    //   }    
    //   return longestLength;
      
       
       //optimal
       Map<Integer,Integer> map = new HashMap<>();
       int maxLength=0,prefixSum=0,k=0;
       for(int index=0;index<n;index++){
           prefixSum+=arr[index];
           if(prefixSum==k)  maxLength=index+1; //as it is 0 based indexing so 
           else{
               if(map.containsKey(prefixSum)) { 
                   maxLength= Math.max(maxLength,index-map.get(prefixSum));//update max length with first occurance of prefixSum
               }
               else map.put(prefixSum,index);
           }
       }
       return maxLength;
    }
}