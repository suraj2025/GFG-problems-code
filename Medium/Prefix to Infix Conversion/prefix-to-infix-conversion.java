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
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // code here
        Stack<String> st=new Stack<>();
        String operator="+-*/^";
        for(int i=0;i<exp.length();i++){
            String s=exp.charAt(i)+"";
            if(operator.contains(s)){
                String A=st.pop();
                String B=st.pop();
                String res="("+B+s+A+")";
                st.push(res);
            }
            else{
                st.push(s);
            }
        }
        return st.pop();
    }
    
    static String reverse(String s){
        StringBuilder input1 = new StringBuilder();
 
        // append a string into StringBuilder input1
        input1.append(s);
 
        // reverse StringBuilder input1
        input1.reverse();
        return input1.toString();
        
    }
    static String preToInfix(String pre_exp) {
        // code here
        String exp=reverse(pre_exp);
        String res=postToInfix(exp);
        res=reverse(res);
         StringBuilder finalResult = new StringBuilder();
        
        for (int i = 0; i < res.length(); i++) {
            char ch = res.charAt(i);
            if (ch == '(') {
                finalResult.append(')');
            } else if (ch == ')') {
                finalResult.append('(');
            } else {
                finalResult.append(ch);
            }
        }
        
        return finalResult.toString();
    }
}
