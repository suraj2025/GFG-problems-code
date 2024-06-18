//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans = ob.rectanglesInCircle(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int rectanglesInCircle(int r) {
        // code here
        int count = 0;
        int diameter = 2 * r;

        for (int i = 1; i <= diameter; i++) {
            for (int j = 1; j <= diameter; j++) {
                // Check if the rectangle with sides i and j can fit inside the circle
                if (Math.sqrt(i * i + j * j) <= diameter) {
                    count++;
                }
            }
        }

        return count;
    }
};