//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            obj.sieve();
            List<Integer> ans = obj.findPrimeFactors(n);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // You must implement this function
    static void sieve() {
        
        
    }
    static void sieve(int[] primes,int n) {
        
        for(int i=2;i*i<n;i++){
            if(primes[i]==i){
                for(int j=i*i;j<n;j+=i){
                    if(primes[j]==j){
                        primes[j]=i;
                    }
                   
                }
            }
        }
    }

    static List<Integer> findPrimeFactors(int N) {
        // code here
        ArrayList<Integer>  res=new ArrayList<>();
         int[] primes = new int[N + 1];
        for(int i=2;i<=N;i++){
            primes[i]=i;
        }
        
        sieve(primes,N+1);
        while(N!=1){
            res.add(primes[N]);
            N=N/primes[N];
        }
        return res;
    }
}
