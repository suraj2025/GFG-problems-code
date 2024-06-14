//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String str1 = sc.next();
            String str2 = sc.next();

            Solution obj = new Solution();
            String ans = obj.betterString(str1, str2);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int countDistinctSubsequences(String str) {
        int n = str.length();
        int MOD = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1; // There's one subsequence for an empty string
        
        // To track the last occurrence of each character
        HashMap<Character, Integer> last = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            char c = str.charAt(i - 1);
            dp[i] = (2 * dp[i - 1]) % MOD;
            
            if (last.containsKey(c)) {
                dp[i] = (dp[i] - dp[last.get(c) - 1] + MOD) % MOD;
            }
            
            last.put(c, i);
        }

        return dp[n] - 1; // Subtract 1 to exclude the empty subsequence
    }

    public static String betterString(String str1, String str2) {
        int count1 = countDistinctSubsequences(str1);
        int count2 = countDistinctSubsequences(str2);

        if (count1 >= count2) {
            return str1;
        } else {
            return str2;
        }
    }
}