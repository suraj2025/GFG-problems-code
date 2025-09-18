class Solution {
   
    static int knapsack(int W, int val[], int weight[]) {
        // code here
        int n=val.length;
        int dp[][]=new int[n+1][W+1];
       
        for(int idx=1;idx<=n;idx++ ){
            for(int wt=1;wt<=W;wt++){
                if(weight[idx-1]<=wt){
                  dp[idx][wt]=Math.max(dp[idx-1][wt],dp[idx-1][wt-weight[idx-1]]+val[idx-1]);
                 }
                 else 
                dp[idx][wt]=dp[idx-1][wt];
            }
        }
        
        
        return dp[n][W];
        
    }
}
