//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
   private int[] parent;
    private int[] size;
    private int[] directions = {-1, 0, 1, 0, -1};
    private int rows, cols;

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }

    public int MaxConnection(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        parent = new int[rows * cols];
        size = new int[rows * cols];

        for (int i = 0; i < rows * cols; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Initialize Union-Find for all 1's in the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    for (int i = 0; i < 4; i++) {
                        int nr = r + directions[i];
                        int nc = c + directions[i + 1];
                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                            union(r * cols + c, nr * cols + nc);
                        }
                    }
                }
            }
        }

        // Calculate initial maximum size of connected 1's
        int maxSize = 0;
        for (int i = 0; i < rows * cols; i++) {
            if (grid[i / cols][i % cols] == 1) {
                maxSize = Math.max(maxSize, size[find(i)]);
            }
        }

        // Try changing each 0 to 1 and recalculate the size of the connected component
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int potentialSize = 1; // size when changing grid[r][c] to 1
                    for (int i = 0; i < 4; i++) {
                        int nr = r + directions[i];
                        int nc = c + directions[i + 1];
                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                            int root = find(nr * cols + nc);
                            if (!seen.contains(root)) {
                                seen.add(root);
                                potentialSize += size[root];
                            }
                        }
                    }
                    maxSize = Math.max(maxSize, potentialSize);
                }
            }
        }

        return maxSize;
    }
}