// User function Template for Java

class Solution {
    public ArrayList<Integer> getLIS(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        int hash[] = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            hash[i] = i;
        }

        int max = 1, lastIndex = 0;

        // Standard LIS DP
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                lastIndex = i;
            }
        }

        // Reconstruct LIS
        ArrayList<Integer> res = new ArrayList<>();
        while (hash[lastIndex] != lastIndex) {
            res.add(arr[lastIndex]);
            lastIndex = hash[lastIndex];
        }
        res.add(arr[lastIndex]); // add the first element

        // Reverse the sequence
        Collections.reverse(res);
        return res;
    }
}
