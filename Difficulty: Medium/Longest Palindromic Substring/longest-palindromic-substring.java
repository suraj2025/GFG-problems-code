class Solution {
    
    public String getLongestPal(String s) {
        // code here
        
        int n = s.length();
        if (n == 0) return "";

        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLen = 1;

        // Substrings of length 1
        for (int i = 0; i < n; i++)
            dp[i][i] = true;

        // Substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                if (2 > maxLen) { // <-- fix here
                    start = i;
                    maxLen = 2;
                }
            }
        }

        // Substrings of length >= 3
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLen) { // update only if strictly longer
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
        
    }
}