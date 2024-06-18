//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToPre(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String exp) {
        // code here
        Stack<String> st=new Stack<>();
        String op="+-*/^";
        for(int i=0;i<exp.length();i++){
            String s=exp.charAt(i)+"";
            if(op.contains(s)){
                String A=st.pop();
                st.push(s+st.pop()+A);
            }
            else{
                st.push(s);
            }
        }
        return st.pop();
    }
}
