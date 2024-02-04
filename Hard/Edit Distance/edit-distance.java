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
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    static int dp[][];
    static int min(int x, int y, int z) {
        if (x <= y && x <= z) return x;
        if (y <= x && y <= z)
            return y;
        else
            return z;
    }
    static int fun(String s, String t, int pos1, int pos2) {
        if (pos1 == 0) return pos2;
        if (pos2 == 0) return pos1;
      

        if (dp[pos1][pos2] != -1) return dp[pos1][pos2];
        if (s.charAt(pos1 - 1) == t.charAt(pos2 - 1))
            return dp[pos1][pos2] = fun(s, t, pos1 - 1, pos2 - 1);
        
        return dp[pos1][pos2] = min(1 + fun(s, t, pos1, pos2 - 1),
                                    1 + fun(s, t, pos1 - 1, pos2),
                                    1 + fun(s, t, pos1 - 1, pos2 - 1));
    }
    public int editDistance(String s, String t) {
        dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++)
            for (int j = 0; j <= t.length(); j++) dp[i][j] = -1;

        int ans = fun(s, t, s.length(), t.length());
        return ans;
    }
}