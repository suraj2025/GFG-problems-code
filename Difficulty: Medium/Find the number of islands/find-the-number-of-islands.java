//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    class Pair{
        int row,col;
        Pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    void BFS(int row,int col,char[][] grid,boolean[][] vis){
        Queue<Pair> q=new LinkedList<>();
        vis[row][col]=true;
        q.offer(new Pair(row,col));
        while(!q.isEmpty()){
            
            Pair p=q.poll();
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int r=p.row+i;
                    int c=p.col+j;
                    if(r>=0&&r<=grid.length-1&&c>=0&&c<=grid[0].length-1&&grid[r][c]=='1'&&!vis[r][c]){
                        vis[r][c]=true;
                        q.offer(new Pair(r,c));
                    }
                }
        }
        }
    }
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int r=grid.length,c=grid[0].length;
        boolean vis[][]=new boolean[r][c];
        int cnt=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(!vis[i][j]&&grid[i][j]=='1'){
                    cnt++;
                    BFS(i,j,grid,vis);
                }
            }
        }
        return cnt;
    }
}