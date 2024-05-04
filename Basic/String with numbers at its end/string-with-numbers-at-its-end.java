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
            String s = read.readLine();
            
            Solution ob = new Solution();
            int result = ob.isSame(s);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isSame(String s) {
        // code here
         int size = s.length(),num=0,i=size-1,multi=1;
        
        while(Character.isDigit(s.charAt(i))){
                num=num+(s.charAt(i)-'0')*multi;
                i--;
                multi*=10;
        }

        if (++i == num)     return 1;
        return 0;
    }
}