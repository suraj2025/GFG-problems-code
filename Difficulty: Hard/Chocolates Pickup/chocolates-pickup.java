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
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // int helper(int i,int j1,int j2,int n, int m, int grid[][]){
    //     if(j1<0||j1>=m||j2<0||j2>=m){
    //         return (int)-1e9;
    //     }
    //     if(i==n-1){
    //         if(j1==j2) return grid[i][j1];
    //         else return grid[i][j1]+grid[i][j2];
    //     }
    //     int maxi=0;
    //     for(int p1=-1;p1<=1;p1++){
    //         for(int p2=-1;p2<=1;p2++){
    //             if(j1==j2){
    //                 maxi=Math.max(maxi,grid[i][j1]+helper(i+1,j1+p1,j2+p2,n,m,grid));
    //             }
    //             else{
    //                 maxi=Math.max(maxi,grid[i][j1]+grid[i][j2]+helper(i+1,j1+p1,j2+p2,n,m,grid));
    //             }
    //         }
    //     }
    //     return maxi;
    // }
    public int solve(int n, int m, int grid[][]) {
        // Code here
        int dp[][][]=new int[n][m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i==j){
                    dp[n-1][i][j]=grid[n-1][i];
                }
                else{
                    dp[n-1][i][j]=grid[n-1][j]+grid[n-1][i];
                }
            }
        }
        for(int i=n-2;i>=0;i--){
            for(int j1=0;j1<m;j1++){
                for(int j2=0;j2<m;j2++){
                    int maxi=(int)-1e8;
                    for(int p1=-1;p1<=1;p1++){
                        for(int p2=-1;p2<=1;p2++){
                            int value = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
                            int nj1 = j1 + p1;
                            int nj2 = j2 + p2;
                            if (nj1 >= 0 && nj1 < m && nj2 >= 0 && nj2 < m) {
                                value+=dp[i+1][nj1][nj2];
                            }
                            else value=(int)-1e8;
                            maxi = Math.max(maxi, value );
                        }
                    }
                    dp[i][j1][j2]=maxi;
                }
            }
        }
        return dp[0][0][m-1];
    }
}