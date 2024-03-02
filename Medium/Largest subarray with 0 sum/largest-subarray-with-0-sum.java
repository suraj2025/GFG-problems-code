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
    int maxLen(int Arr[], int N)
    {
        // Your code here
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