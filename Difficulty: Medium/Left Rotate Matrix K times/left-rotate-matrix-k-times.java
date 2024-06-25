//{ Driver Code Starts
// Initial Template for java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            int k = Integer.parseInt(S[2]);
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                String S1[] = read.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    mat[i][j] = Integer.parseInt(S1[j]);
                }
            }
            Solution ob = new Solution();
            int ans[][] = ob.rotateMatrix(k, mat);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function template for java

class Solution {
    public static void reverse(int nums[], int start, int end){
    // While start index is less than end index
    while(start < end){
        // Swap elements at start and end indices
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        // Increment start index and decrement end index
        start++;
        end--;
    }
}

    public void rotate(int[] nums, int k) {
        // Ensure k is within array bounds
        k %= nums.length;
        k=nums.length-k;
        // Reverse entire array
        reverse(nums, 0, nums.length - 1);
        // Reverse first k elements
        reverse(nums, 0, k - 1);
        // Reverse remaining elements
        reverse(nums, k, nums.length - 1);
    }
    int[][] rotateMatrix(int k, int mat[][]) {
        // code here
        for(int i=0;i<mat.length;i++){
            rotate(mat[i],k);
        }
        return mat;
    }
}