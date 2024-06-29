//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int M = Integer.parseInt(inputLine[0]);
		    int N = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(M, N));
		}
	}
}




// } Driver Code Ends

class Solution {
    static final int MOD = 1000000007;

    long modInverse(long a, int mod) {
        return power(a, mod - 2, mod);
    }

    long power(long x, int y, int p) {
        long res = 1; 
        x = x % p; 
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % p;
            y = y >> 1; 
            x = (x * x) % p; 
        }
        return res;
    }

    long modBinomialCoefficient(int n, int k, int mod) {
        if (k > n) return 0;
        long res = 1;
        for (int i = 0; i < k; i++) {
            res = (res * (n - i)) % mod;
            res = (res * modInverse(i + 1, mod)) % mod;
        }
        return res;
    }

    long numberOfPaths(int M, int N) {
        int totalSteps = M + N - 2;
        int downSteps = M - 1;
        return modBinomialCoefficient(totalSteps, downSteps, MOD);
    }
}



// class Solution{
//     long count(int r,int c,int i,int j){
//         if(i==r-1&&j==c-1){
//             return 1;
//         }
//         if(i>r-1||j>c-1) return 0;
//         return 1L*(count(r,c,i,j+1)+count(r,c,i+1,j))%1000000007;
//     }
//     long numberOfPaths(int M, int N) {
//         // Code Here
//         return count(M,N,0,0);
//     }
    
// }