class Solution {
    static Boolean helper(int arr[],int S,int idx){
        if(S==0) return true;
        if(idx==0) return false;
        
        if(arr[idx-1]<=S){
            return helper(arr,S,idx-1)||helper(arr,S-arr[idx-1],idx-1);
        }
        return helper(arr,S,idx-1);
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n=arr.length;
        boolean dp[]=new boolean[sum+1];
        dp[0]=true;
        for(int idx=1;idx<=n;idx++){
            for(int S=sum;S>=1;S--){
                if(arr[idx-1]<=S){
                    dp[S]=dp[S]||dp[S-arr[idx-1]];
                  }
                  else
                dp[S]=dp[S];
            }
        }
        return dp[sum];
    }
}