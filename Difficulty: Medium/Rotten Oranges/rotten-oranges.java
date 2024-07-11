//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    class Triplet{
        int r,c,t;
        Triplet(int r,int c,int t){
            this.r=r;
            this.c=c;
            this.t=t;
        }
    }
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int vis[][]=grid;
        int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};
        int n=grid.length;
        int m=grid[0].length;
        Queue<Triplet> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==2){
                    q.offer(new Triplet(i,j,0));
                }
            }
        }
        int time=0;
        while(!q.isEmpty()){
            Triplet tri=q.poll();
            time=Math.max(time,tri.t);
            for(int i=0;i<4;i++){
                int nr=tri.r+row[i];
                int nc=tri.c+col[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&vis[nr][nc]!=2&&vis[nr][nc]!=0){
                    vis[nr][nc]=2;
                    q.offer(new Triplet(nr,nc,tri.t+1));
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==1){
                    return -1;
                }
            }
        }
        
       return time;
    }
}