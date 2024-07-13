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

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends




class Solution {
    void DFS(int row, int col, int[][] grid, boolean[][] vis, int[][] directions, StringBuilder shape, int baseRow, int baseCol) {
        vis[row][col] = true;
        
        // Append the relative position to the shape
        shape.append((row - baseRow) + "" + (col - baseCol) + " ");
        
        for (int[] d : directions) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1 && !vis[newRow][newCol]) {
                DFS(newRow, newCol, grid, vis, directions, shape, baseRow, baseCol);
            }
        }
    }

    // Function to find the number of distinct islands.
    public int countDistinctIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        Set<String> uniqueIslands = new HashSet<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    StringBuilder shape = new StringBuilder();
                    DFS(i, j, grid, vis, directions, shape, i, j);
                    uniqueIslands.add(shape.toString().trim());
                }
            }
        }
        
        return uniqueIslands.size();
    }
}

