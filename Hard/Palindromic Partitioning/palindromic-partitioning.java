//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str) {
        int n = str.length();
        if (n == 0) return 0;

        // dp[i][j] will be true if substring str[i..j] is a palindrome
        boolean[][] dp = new boolean[n][n];

        // Initialize all substrings of length 1 as palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Fill the table for substrings of length > 1
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                if (str.charAt(i) == str.charAt(j)) {
                    if (length == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }

        // minCuts[i] will be the minimum number of cuts needed for the substring str[0..i]
        int[] minCuts = new int[n];
        Arrays.fill(minCuts, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if (dp[0][i]) {
                minCuts[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i] && minCuts[j] + 1 < minCuts[i]) {
                        minCuts[i] = minCuts[j] + 1;
                    }
                }
            }
        }

        return minCuts[n - 1];
    }

}