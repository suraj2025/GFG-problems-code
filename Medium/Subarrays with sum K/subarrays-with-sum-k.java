//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.findSubArraySum(Arr, N, k));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int findSubArraySum(int Arr[], int N, int k)
    {
        // code here
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
                count++;
            }
            // If there exists a prefix sum preSum - k, add its frequency to count
            if (prefixSums.containsKey(preSum - k)) {
                count += prefixSums.get(preSum - k);
            }
            // Update the frequency of the current prefix sum
            prefixSums.put(preSum, prefixSums.getOrDefault(preSum, 0) + 1);
        }
        // Return the count of subarrays
        return count;
    }
}