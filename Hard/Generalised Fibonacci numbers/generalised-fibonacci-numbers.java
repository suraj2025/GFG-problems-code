//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            long a = Long.parseLong(S[0]);
            long b = Long.parseLong(S[1]);
            long c = Long.parseLong(S[2]);
            long n = Long.parseLong(S[3]);
            long m = Long.parseLong(S[4]);

            Solution ob = new Solution();
            System.out.println(ob.genFibNum(a,b,c,n,m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long mat[][],res[][]; // declare matrices to hold values
    static long genFibNum(Long a, Long b, Long c, long n, long m) {
        mat=new long[3][3]; // initialize matrix mat
        res=new long[3][3]; // initialize matrix res
        res[0][0] = res[1][1] = res[2][2] = 1; // set diagonal elements of res to 1
        mat[0][0] = a; // set value of a to mat[0][0]
        mat[0][1] = b; // set value of b to mat[0][1]
        mat[0][2] = mat[1][0] = mat[2][2] = 1; // set specific elements of mat to 1
        mat[1][1] = mat[1][2] = mat[2][0] = mat[2][1] = 0; // set specific elements of mat to 0

        if(n<=2) // check if n is less than or equal to 2
            return (1%m); // return 1 modulo m
        else {
            mat_exp(n-2,m); // apply matrix exponentiation
            return (res[0][0] + res[0][1] + c*res[0][2])%m; // calculate the value using res and return modulo m
        }
    }
    
    static void mul(long res[][], long mat[][], long m) {
        long res1[][]=new long[3][3]; // initialize temporary matrix res1

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                for(int k=0; k<3; k++) {
                    res1[i][j] += (res[i][k]*mat[k][j]); // calculate matrix multiplication
                    res1[i][j] %= m; // apply modulo m
                }
            }
        }
        
        // copy values from res1 to res
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                res[i][j]=res1[i][j];
    }
    
    static void mat_exp(long n, long m) {
        while(n>0) {
            if((n&1)!=0) // check if n is odd
                mul(res, mat, m); // multiply res and mat
            mul(mat,mat,m); // square mat
            n /= 2; // divide n by 2
        }
    }
}