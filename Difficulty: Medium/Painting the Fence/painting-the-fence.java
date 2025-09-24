// User function Template for Java

class Solution {
    // int fun()
    int countWays(int n, int k) {
        // // code here.
        // if(n==1) return k;
        // if(n==2) return k*k;
        // return (countWays(n-1,k)+countWays(n-2,k))*(k-1);
        if(n==1) return k;
        int a=k,b=k*k;
        for(int i=3;i<=n;i++){
            int c=(a+b)*(k-1);
            a=b;
            b=c;
        }
        return b;
    }
}
