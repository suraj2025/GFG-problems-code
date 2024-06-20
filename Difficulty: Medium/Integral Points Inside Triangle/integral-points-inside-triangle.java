//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            long p[] = new long[2];
            long q[] = new long[2];
            long r[] = new long[2];
            p[0] = Long.parseLong(S[0]);
            p[1] = Long.parseLong(S[1]);
            q[0] = Long.parseLong(S[2]);
            q[1] = Long.parseLong(S[3]);
            r[0] = Long.parseLong(S[4]);
            r[1] = Long.parseLong(S[5]);
            Solution ob = new Solution();
            long ans = ob.InternalCount(p, q, r);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java



class Solution {

    public long gcd(long a, long b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    public long InternalCount(long[] p, long[] q, long[] r) {
        // Extract coordinates
        long p1 = p[0], p2 = p[1];
        long q1 = q[0], q2 = q[1];
        long r1 = r[0], r2 = r[1];

        // Calculate the area using the determinant method
        long area = Math.abs(p1 * (q2 - r2) + q1 * (r2 - p2) + r1 * (p2 - q2));

        // Calculate boundary points using gcd
        long boundaryPoints = gcd(Math.abs(q1 - p1), Math.abs(q2 - p2)) +
                              gcd(Math.abs(r1 - q1), Math.abs(r2 - q2)) +
                              gcd(Math.abs(p1 - r1), Math.abs(p2 - r2));

        // Apply Pick's theorem to find the number of integral points inside the triangle
        long interiorPoints = (area - boundaryPoints + 2) / 2;
        return interiorPoints;
    }

    
}
