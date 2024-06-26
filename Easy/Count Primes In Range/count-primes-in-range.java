//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int L = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            System.out.println(ob.countPrimes(L, R));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int count(int n){
        
        int prime[]=new int [n+1];
        for(int i=2;i<n+1;i++){
            prime[i]=1;
        }
        
        for(int i=2;i*i<=n;i++){
            if(prime[i]==1){
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=0;
                }
            }
        }
        int cnt=0;
        for(int i=2;i<=n;i++){
            if(prime[i]==1) cnt++;
        }
        return cnt;
        
    }
    int countPrimes(int L, int R) {
        // code here
        return count(R)-count(L-1);
    }
};