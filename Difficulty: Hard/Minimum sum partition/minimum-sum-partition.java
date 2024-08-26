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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int isSubsetSum(int N, int arr[], int sum){
        // code here
        boolean dp[]=new boolean[sum+1];
        for(int i=0;i<N;i++){
            dp[0]=true;
        }
         if (arr[0] <= sum) {
            dp[arr[0]] = true;
        }
        
        for(int i=1;i<N;i++){
            boolean curr[]=new boolean[sum+1];
            for(int k=1;k<=sum;k++){
                boolean notPick=dp[k];
                boolean pick=false;
                if(k>=arr[i]){
                    pick=dp[k-arr[i]];
                }
                curr[k]=pick||notPick;
            }
            dp=curr;
        }
        int mini=(int)1e9;
        for(int i=0;i<=sum;i++){
            if(dp[i]){
                int s1=i;
                int s2=sum-s1;
                mini=Math.min(mini,Math.abs(s1-s2));
            }
        }
        return mini;
    }
   


	public int minDifference(int nums[], int n) 
	{ 
	    // Your code goes here
	    int sum=0;
        for(int i=0;i<n;i++) sum+=nums[i];
       
        return isSubsetSum(n,nums,sum);
	} 
}
