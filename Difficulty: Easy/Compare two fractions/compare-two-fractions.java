//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code here
        String f1=str.substring(0,str.indexOf(','));
        String f2=str.substring(str.indexOf(',')+2);
        int a=Integer.parseInt(f1.substring(0,f1.indexOf('/')));
        int b=Integer.parseInt(f1.substring(f1.indexOf('/')+1));
        int c=Integer.parseInt(f2.substring(0,f2.indexOf('/')));
        int d=Integer.parseInt(f2.substring(f2.indexOf('/')+1));
        
        int A1=a*d,A2=c*b;
        if(A1==A2) return "equal";
        else if(A1>A2){
            return f1;
        }
        return f2;
    }
}
