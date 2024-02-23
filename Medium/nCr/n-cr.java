//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
     static long power(long x,long y,long mod){
       if (y == 0)
           return 1;
       long p = power(x, y/2, mod) % mod;
       p = (p * p) % mod;
    
       return (y%2 == 0)? p : (x * p) % mod;
   }
    static long nCr(int n, int r){
        //complete the function here
         long mod=1000000007;
       long[] dp=new long[n+1];
       dp[0]=1;
       
       for(int i = 1; i <= n; i++){
           dp[i] = (i * dp[i - 1]) % mod;
       }
       
       if(r > n) {
           return 0;
       }
       long up = dp[n], down = (dp[r] * dp[n - r]) % mod;
       long ans = (up * power(down, mod - 2, mod)) % mod;
       long deep = ans;
       return deep;
    }
}