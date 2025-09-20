class Solution {
    public int cutRod(int[] price) {
        // code here
        int n=price.length;
        int dp[]=new int[n+1];
        for(int idx=1;idx<=n;idx++){
            for(int c=1;c<=n;c++){
                if(idx<=c){
                    dp[c]=Math.max(dp[c],dp[c-idx]+price[idx-1]);
                }
            }
        }
        return dp[n];
        
    }
}