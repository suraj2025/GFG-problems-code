// User function Template for Java

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int l1=s1.length(),l2=s2.length();
        int dp[]=new int[l2+1];
        int temp[]=new int[l2+1];
        int res=0;
        for(int idx1=1;idx1<=l1;idx1++){
            for(int idx2=1;idx2<=l2;idx2++){
                if(s1.charAt(idx1-1)==s2.charAt(idx2-1)) {
                temp[idx2]=1+dp[idx2-1];
               res=Math.max(res,temp[idx2]);}
               else {
                    temp[idx2] = 0; // reset when mismatch
                }
            }
            
            dp=temp.clone();
        }
        return res;
        
    }
}