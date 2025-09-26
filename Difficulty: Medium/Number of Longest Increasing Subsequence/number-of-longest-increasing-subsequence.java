class Solution {
    public int numberofLIS(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        int count[] = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];  // start new sequence
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j]; // add all sequences
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        // Sum counts for all indices with LIS length
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) total += count[i];
        }

        return total;
    }
}
