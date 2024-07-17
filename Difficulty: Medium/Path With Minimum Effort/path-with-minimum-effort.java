//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int rows;
            rows = Integer.parseInt(br.readLine());

            int columns;
            columns = Integer.parseInt(br.readLine());

            int[][] heights = IntMatrix.input(br, rows, columns);

            Solution obj = new Solution();
            int res = obj.MinimumEffort(rows, columns, heights);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public  int MinimumEffort(int n, int m, int[][] heights) {
        // code her
        int dist[][]=new int [n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        dist[0][0]=0;
        int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};
        while(!pq.isEmpty()){
            int t[]=pq.poll();
            int effort=t[0];
            int x=t[1];
            int y=t[2];
            for(int i=0;i<4;i++){
                int xi=x+row[i];
                int yi=y+col[i];
                if (xi >= 0 && xi < n && yi >= 0 && yi < m) {
                    int currentEffort = Math.abs(heights[xi][yi] - heights[x][y]);
                    int maxEffort = Math.max(effort, currentEffort);

                    if (maxEffort < dist[xi][yi]) {
                        dist[xi][yi] = maxEffort;
                        pq.add(new int[]{maxEffort, xi, yi});
                    }
                }
            }

        }
        return dist[n-1][m-1];
    }
}
