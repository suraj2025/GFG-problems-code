//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.totalWays(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int totalWays(int m, int n, int grid[][]) {
        // Code here
       
        int dp[]=new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0){
                    dp[j]=1;
                }
                if(grid[i][j]==1){
                    dp[j]=0;
                }
                else{
                    dp[j]+=j>0?dp[j-1]:0;
                    dp[j]=dp[j]%(int)(1e9+7);
                }
            }
        }
        return dp[n-1];
    }
}