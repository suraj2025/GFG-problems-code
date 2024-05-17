//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;
        int n = v.length;
        
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }
    
    static int time(int[] nums, int mid, int n) {
        int t = 0;
        for (int i = 0; i < n; i++) {
            t+=Math.ceil((double) nums[i] / mid);
        }
        return t;
    }
   
    public static int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        if(n>threshold) return -1;
        int l = 1, h = findMax(nums);
        
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int total = time(nums, mid, n);
            if (total <= threshold) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}