// User function Template for Java

class Solution {
    public long countFriendsPairings(int n) {
        // code here
        if(n==1) return 1;
        int a=1,b=2;
        for(int i=3;i<=n;i++){
            int c=b+(i-1)*a;
            a=b;
            b=c;
        }
        return b;
        
    }
}
