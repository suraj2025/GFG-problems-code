//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            long a = Long.parseLong(S[0]);
            long b = Long.parseLong(S[1]);
            long c = Long.parseLong(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.rightAngTri(a,b,c));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static String rightAngTri(long a, long b, long c) {
        // code here
        long k=Math.max(Math.max(a,b),c);
        if(k==a&&(a*a==b*b+c*c)){
            return "Yes";
        }
        else if(k==b&&(b*b==a*a+c*c)){
            return "Yes";
        }
        else if(k==c&&(a*a+b*b==c*c)){
            return "Yes";
        }
        else{
            return "No";
        }
    }
};