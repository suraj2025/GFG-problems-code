class Solution {
    public static int longestPS(String s) {
        int n=s.length();
        int dp[][]=new int[n+1][n+1];
        StringBuilder stringBuilder = new StringBuilder(s);

        // Reverse the StringBuilder
        stringBuilder.reverse();

        // Convert the reversed StringBuilder back to a String
        String s1 = stringBuilder.toString();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s1.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][n];
    }
    static int minDeletions(String s) {
        // code here
        return s.length()-longestPS(s);
        
    }
}