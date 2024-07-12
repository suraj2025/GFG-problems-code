//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    void DFS(int row,int col,char board[][],boolean vis[][]){
        vis[row][col]=true;
        int n=board.length;
        int m=board[0].length;
        int r[]={-1,0,1,0};
        int c[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr=row+r[i];
            int nc=col+c[i];
            if(nr>=0&&nr<n&&nc>=0&&nc<m&&!vis[nr][nc]&&board[nr][nc]=='O'){
                DFS(nr,nc,board,vis);
            }
        }
    }
    public char[][] fill(int n,int m,char[][] board) {
        
        boolean vis[][]=new boolean[n][m];
        int row=0,col=0;
        for(int i=0;i<n;i++){
            if(board[i][col]=='O'&&!vis[i][col]){
                DFS(i,col,board,vis);
            }
        }
        for(int i=0;i<m;i++){
            if(board[row][i]=='O'&&!vis[row][i]){
                DFS(row,i,board,vis);
            }
        }
        row=n-1;
        col=m-1;
        for(int i=0;i<n;i++){
            if(board[i][col]=='O'&&!vis[i][col]){
                DFS(i,col,board,vis);
            }
        }
        for(int i=0;i<m;i++){
            if(board[row][i]=='O'&&!vis[row][i]){
                DFS(row,i,board,vis);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'&&!vis[i][j]){
                    board[i][j]='X';
                }
            }
        }
        return board;
        
    }
    
}