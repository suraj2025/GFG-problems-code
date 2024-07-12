//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] board) {

        // Your code here
        int n=board.length;
        int m=board[0].length;
        boolean vis[][]=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(board[i][0]==1){
                q.offer(new int[]{i,0});
                vis[i][0]=true;
            }
            if(board[i][m-1]==1){
                q.offer(new int[]{i,m-1});
                vis[i][m-1]=true;
            }
        }
        for(int i=0;i<m;i++){
            if(board[0][i]==1){
                q.offer(new int[]{0,i});
                vis[0][i]=true;
            }
            if(board[n-1][i]==1){
                q.offer(new int[]{n-1,i});
                vis[n-1][i]=true;
            }
        }
        int r[]={-1,0,1,0};
        int c[]={0,1,0,-1};
        while(!q.isEmpty()){
            int pair[]=q.poll();
            for(int i=0;i<4;i++){
                int nr=pair[0]+r[i];
                int nc=pair[1]+c[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&!vis[nr][nc]&&board[nr][nc]==1){
                    vis[nr][nc]=true;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==1&&!vis[i][j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}