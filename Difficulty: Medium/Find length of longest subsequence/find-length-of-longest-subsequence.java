// User function Template for Java
class Solution {
    int helper(int i,int j,String X, String Y,int count){
        if(i==0||j==0) return count;
        int res=count;
        if(X.charAt(i-1)==Y.charAt(j-1)){
            res=Math.max(res,helper(i-1,j-1,X,Y,count+1));
        }
        res=Math.max(res,helper(i-1,j,X,Y,count));
        res=Math.max(res,helper(i,j-1,X,Y,0));
        return res;
        
    }
    int maxSubsequenceSubstring(String X, String Y, int N, int M) {
        // code here
        int dp[]=new int[M+1];
        int res=0;
        for(int i=1;i<=N;i++){
            for(int j=M;j>=1;j--){
                if(X.charAt(i-1)==Y.charAt(j-1)){
                    dp[j]=dp[j-1]+1;
                }
                else dp[j]=dp[j];
                
                res=Math.max(res,dp[j]);
               
            }
        }
        
    //   System.out.println(Arrays.toString(dp)); 
        return res;
        
    }
}