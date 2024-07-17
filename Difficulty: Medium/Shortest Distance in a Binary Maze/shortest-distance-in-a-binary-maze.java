//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    class Triplet{
        int distance,row,col;
        Triplet(int d,int r,int c){
             distance=d;
             row=r;
             col=c;
             
        }
    }
   

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        int n=grid.length;
        int m=grid[0].length;
        int i1=source[0];
        int j1=source[1];
        int i2=destination[0];
        int j2=destination[1];
        if(grid[i1][j1]==0) return -1;
        int r1[]={-1,0,1,0};
        int c1[]={0,1,0,-1};
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){

        Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[i1][j1]=0;;

        Queue<Triplet> q=new LinkedList<>();
        q.offer(new Triplet(0,i1,j1));
        while(!q.isEmpty()){
            Triplet t=q.poll();
            int d=t.distance;
            int r=t.row;
            int c=t.col;
            for(int i=0;i<4;i++){
                int nr=r+r1[i];
                int nc=c+c1[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&grid[nr][nc]==1){
                    if(d+1<dist[nr][nc]){
                        dist[nr][nc]=d+1;
                        q.offer(new Triplet(d+1,nr,nc));
                    }
                }
                
            }
        }
        return dist[i2][j2]==Integer.MAX_VALUE?-1:dist[i2][j2];
    }
}
