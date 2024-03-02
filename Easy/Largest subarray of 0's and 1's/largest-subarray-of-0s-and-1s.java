//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.HashMap;

class Largest_Subarray
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for (int i = 0; i < N; i++) 
                a[i] = sc.nextInt();
            

            Solution g = new Solution();
            int n = g.maxLen(a, a.length);

            System.out.println(n);

            T--;
        }
    }
}

// } Driver Code Ends




class Solution {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array
    
    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] Arr, int N)
    {
        // Your code here
        for(int i=0;i<N;i++){
            if(Arr[i]==0){
                
            Arr[i]=-1;
            }
        }
        int k=0;
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
