class Solution {
    public int countPS(String s) {
        int n = s.length();
        int count = 0;

        for (int center = 0; center < n; center++) {
            // Odd length palindromes
            count += expand(s, center, center);

            // Even length palindromes
            count += expand(s, center, center + 1);
        }

        return count;
    }

    private int expand(String s, int left, int right) {
        int cnt = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > 1) cnt++; // count only length > 1
            left--;
            right++;
        }
        return cnt;
    }
}
