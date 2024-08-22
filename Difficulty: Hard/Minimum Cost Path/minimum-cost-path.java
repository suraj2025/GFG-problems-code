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
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




class Solution {
    // Directions for moving in the grid (left, right, up, down)
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};
    
    public int minimumCostPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Min-heap priority queue for Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        // Distance array to store the minimum cost to reach each cell
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Start from the top-left corner
        pq.offer(new int[]{0, 0, grid[0][0]});
        dist[0][0] = grid[0][0];
        
        // Process the priority queue
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0];
            int y = current[1];
            int cost = current[2];
            
            // If we reach the bottom-right corner, return the cost
            if (x == m - 1 && y == n - 1) {
                return cost;
            }
            
            // Explore all four possible directions
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // Check if the new position is within the grid bounds
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newCost = cost + grid[nx][ny];
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.offer(new int[]{nx, ny, newCost});
                    }
                }
            }
        }
        
        // If we exhaust the queue without reaching the bottom-right corner
        return -1; // This should never happen in a valid grid
    }
}
