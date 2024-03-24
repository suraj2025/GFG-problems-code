//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int[] ans = obj.sortedArrayToBST(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
     public int[] sortedArrayToBST(int[] nums)
    {
        int n = nums.length;
        int ans[] = new int[n];
        int low = 0;
        int high = n-1;
        helper(low, high, nums, ans);
        return ans;
    }
    
    int i = 0;
    
    void helper(int low, int high, int nums[], int ans[]){
        if(low > high) return;
        int mid = low +  (high - low) / 2;
        ans[i++] = nums[mid];
        helper(low, mid - 1, nums, ans);
        helper(mid + 1, high, nums, ans);
    }
}