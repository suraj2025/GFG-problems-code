//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

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
            long res = obj.solve(N, M, grid);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int fun(int i,int j1,int j2,int n,int m,int grid[][],int dp[][][]){
        if(j1<0||j1>=m||j2<0||j2>=m) return Integer.MIN_VALUE;
        if(i==n-1){
            if(j1==j2) return grid[i][j1];
            return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int maxi=Integer.MIN_VALUE;
        for(int d1=-1;d1<=1;d1++){
            for(int d2=-1;d2<=1;d2++){
                int ans=fun(i+1,j1+d1,j2+d2,n,m,grid,dp);
                maxi=Math.max(maxi,ans);
            }
        }
        if(j1==j2)  maxi+=grid[i][j1];
        else maxi+=grid[i][j1]+grid[i][j2];
        return dp[i][j1][j2]=maxi;
    }
    public int solve(int n, int m, int grid[][]) {
        int dp[][][]=new int[n][m][m];
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2) dp[n-1][j1][j2]=grid[n-1][j1];
               else dp[n-1][j1][j2]=grid[n-1][j1]+grid[n-1][j2];
            }
        }
        
        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int maxi=Integer.MIN_VALUE;
                    for(int d1=-1;d1<=1;d1++){
                        for(int d2=-1;d2<=1;d2++){
                            
                            if(j1+d1>=0&&j1+d1<m&&j2+d2>=0&&j2+d2<m){
                                int ans=dp[i+1][j1+d1][j2+d2];
                                maxi=Math.max(maxi,ans);
                                
                            }
                        //     int newJ1 = j1 + d1;
                        //     int newJ2 = j2 + d2;

                        // // Check if the new positions are within bounds
                        //     if (newJ1 >= 0 && newJ1 < m && newJ2 >= 0 && newJ2 < m) {
                        //         int ans = dp[i + 1][newJ1][newJ2];
                        //         maxi = Math.max(maxi, ans);
                        //     }
                        }
                    }
                    if(j1==j2)  maxi+=grid[i][j1];
                    else maxi+=grid[i][j1]+grid[i][j2];
                    dp[i][j1][j2]=maxi;
                }
            }
        }
        
        // Code here
        return dp[0][0][m-1];
    }
}