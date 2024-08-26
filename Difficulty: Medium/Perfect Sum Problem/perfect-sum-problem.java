//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    
    // int isSubsetSum(int N, int arr[], int sum){
    //     // code here
        
    // }

	public int perfectSum(int arr[],int N, int sum) 
	{ 
	    // Your code goes here
	    arr = Arrays.stream(arr)
            .boxed()
            .sorted(Comparator.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

	     int dp[] = new int[sum + 1];
        
        // Initialize dp for sum 0
        
            dp[0] = 1;
        
        if (arr[0] <= sum) {
            dp[arr[0]] = 1;
        }
        
        // Fill dp table
        for (int i = 1; i < N; i++) {
            int curr[]=new int[sum+1];
            for (int k = 0; k <= sum; k++) {
                int notPick = dp[k];
                int pick = 0;
                if (k >= arr[i]) {
                    pick = dp[k - arr[i]];
                }
                curr[k] = (pick + notPick)%((int)1e9+7);
            }
            dp=curr;
        }
        
        return dp[sum];
	} 
}