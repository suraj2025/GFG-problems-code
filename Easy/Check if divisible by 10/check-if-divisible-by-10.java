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
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.isDivisibleBy10(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int isDivisibleBy10(String bin) {
           if(bin.charAt(bin.length()-1)=='1')

           return 0;

        int sm = 0;

       

        int rm[] = {1,2,4,3};

        int n = bin.length();

        for(int i = 0; i < n;i++){

            int b = bin.charAt(n-1-i)-'0';

            sm += b * rm[i%rm.length];

        }

        return sm%5==0?1:0;
    }
}
