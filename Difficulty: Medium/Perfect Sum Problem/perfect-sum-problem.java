class Solution {
    // Function to calculate the number of subsets with a given sum
    int helper(int[] nums, int sum,int idx){
        if (idx == 0) {
            if (sum == 0 && nums[0] == 0) return 2;  // {} and {0}
            if (sum == 0 || sum == nums[0]) return 1; // {} or {nums[0]}
            return 0;
        }

        // Exclude current element
        int exclude = helper(nums, sum, idx - 1);

        // Include current element (if it doesn't exceed sum)
        int include = 0;
        if (nums[idx] <= sum) {
            include = helper(nums, sum - nums[idx], idx - 1);
        }

        return exclude + include;
    }
    public int perfectSum(int[] nums, int target) {
        // code here
        int n=nums.length;
        int dp[]=new int[target+1];
        for(int idx=0;idx<n;idx++){
            for(int sum=target;sum>=0;sum--){
                if (idx == 0) {
                     if (sum == 0 && nums[0] == 0) dp[sum]= 2;  // {} and {0}
                     else if (sum == 0 || sum == nums[0]) dp[sum]= 1; // {} or {nums[0]}
                }
                else{
                    
                // Exclude current element
                int exclude = dp[sum];

                // Include current element (if it doesn't exceed sum)
                int include = 0;
                if (nums[idx] <= sum) {
                    include = dp[sum - nums[idx]];
                }
        
                dp[sum]=exclude + include;
                }
                
            }
        }
        return dp[target];
        
    }
}