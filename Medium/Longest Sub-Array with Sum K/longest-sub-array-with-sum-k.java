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
    public static int lenOfLongSubarr (int Arr[], int N, int k) {
        //Complete the function
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        // Initializing the prefix sum and count of subarrays
        int preSum = 0;
        int count = 0;
        // Iterating through the array
        for (int i = 0; i < N; i++) {
            // Adding the current element to the prefix sum
            preSum += Arr[i];
            // If prefix sum is equal to k, increment count
            if (preSum == k) {
                count=i+1;;
            }
            // If there exists a prefix sum preSum - k, add its frequency to count
            if (!prefixSums.containsKey(preSum)) {
                // count += prefixSums.get(preSum - k);
            prefixSums.put(preSum, i);
            }
            if(prefixSums.containsKey(preSum-k)){
                count=Math.max(count,i-prefixSums.get(preSum-k));
            }
            // Update the frequency of the current prefix sum
            
        }
        // Return the count of subarrays
        return count;
    }
    
    
}


