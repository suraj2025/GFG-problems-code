//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int m = Integer.parseInt(br.readLine().trim());

            int ans = new Solve().findZeroes(arr, n, m);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    // m is maximum of number zeroes allowed to flip
    int findZeroes(int nums[], int n, int m) {
        // code here
        int l=0;
        int maxLen=0;
        int zero=0;
        for(int r=0;r<nums.length;r++){
            if(nums[r]==0) zero++;
            while (zero > m) {
                if (nums[l] == 0) {
                    zero--; 
                }
                l++; 
            }
            maxLen=Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
}