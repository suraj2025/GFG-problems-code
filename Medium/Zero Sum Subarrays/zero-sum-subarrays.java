//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] Arr ,int N) 
    {
        //Your code here
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        // Initializing the prefix sum and count of subarrays
        int preSum = 0;
        int count = 0;
        // Iterating through the array
        for (int i = 0; i < N; i++) {
            // Adding the current element to the prefix sum
            preSum += Arr[i];
            // If prefix sum is equal to k, increment count
            if (preSum == 0) {
                count++;
            }
            // If there exists a prefix sum preSum - k, add its frequency to count
            if (prefixSums.containsKey(preSum )) {
                count += prefixSums.get(preSum);
            }
            // Update the frequency of the current prefix sum
            prefixSums.put(preSum, prefixSums.getOrDefault(preSum, 0) + 1);
        }
        // Return the count of subarrays
        return count;
    }
}