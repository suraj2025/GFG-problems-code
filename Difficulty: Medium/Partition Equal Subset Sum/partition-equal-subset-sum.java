//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
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
        return dp[sum];
    }
    
    static int equalPartition(int n, int nums[])
    {
        // code here
        int sum=0;
       
        for(int i=0;i<n;i++) sum+=nums[i];
        if(sum%2!=0) return 0;
        return isSubsetSum(n,nums,sum/2)?1:0;
    }
}