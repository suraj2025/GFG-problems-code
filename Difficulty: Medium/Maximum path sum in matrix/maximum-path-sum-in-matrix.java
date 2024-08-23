//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int n, int mat[][])
    {
        // code here
        
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++) dp[0][i]=mat[0][i];

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int top=mat[i][j]+dp[i-1][j];
                int topRight=Integer.MIN_VALUE; 
                if(j<n-1) topRight=mat[i][j]+dp[i-1][j+1];
                int topLeft=Integer.MIN_VALUE; 
                if(j>0) topLeft=mat[i][j]+dp[i-1][j-1];
                dp[i][j]=Math.max(Math.max(top, topRight), topLeft);
            }
        }
        int res = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[n-1][i]);
        }
        
        return res;
    }
}