class Solution {
    public int LCS(String text1, String text2) {

        int l1=text1.length(),l2=text2.length();
        int dp[]=new int[l2+1];
        int temp[]=new int[l2+1];
        for(int idx1=1;idx1<=l1;idx1++){
            for(int idx2=1;idx2<=l2;idx2++){
                if(text1.charAt(idx1-1)==text2.charAt(idx2-1)) temp[idx2]=1+dp[idx2-1];
                else
                 temp[idx2]=Math.max(dp[idx2],temp[idx2-1]);
            }
            dp=temp.clone();
        }
        return dp[l2];
    }
    
        // code here
        public boolean isSubSeq(String s1, String s2) {
    int i = 0, j = 0;
    while (i < s1.length() && j < s2.length()) {
        if (s1.charAt(i) == s2.charAt(j)) i++;
        j++;
    }
    return i == s1.length();


    }
};