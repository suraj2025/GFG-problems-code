class Solution {
    
    int helper(int i,int j,String txt, String pat){
        if(j==0) return 1;
        if(i==0) return 0;
        int notTake=helper(i-1,j,txt,pat);
        int take=0;
        if(txt.charAt(i-1)==pat.charAt(j-1)){
            take=helper(i-1,j-1,txt,pat);
        }
        return take+notTake;
    }
    public int subseqCount(String txt, String pat) {
        // code here
        int n=txt.length(),m=pat.length();
        int dp[]=new int[m+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            for(int j=m;j>=1;j--){
                if(txt.charAt(i-1)==pat.charAt(j-1)){
                    dp[j]+=dp[j-1];
                }
            }
        }
        return dp[m];
        
    }
}