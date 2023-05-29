//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t =sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			Solution ob = new Solution();
			System.out.println(ob.maxDistance(arr,n));
		
		t--;
		}
	}
}
// } Driver Code Ends


// your task is to complete this function
class Solution
{
    int maxDistance(int arr[], int n)
    {
	// Your code here
     	Map<Integer,Integer> map = new HashMap<>();
	    int size=arr.length;
	    int maxDistance=0;
	    for(int index=0;index<size;index++){
	        if(map.containsKey(arr[index])){
	            int firstOccurance=map.get(arr[index]);
	            maxDistance=Math.max(maxDistance,index-firstOccurance);
	        }
	        else{
	            map.put(arr[index],index);
	        }
	    }
	    return maxDistance;
    }
}
