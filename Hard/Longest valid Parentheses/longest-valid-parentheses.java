//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
     static int maxLength(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // Initial index to handle the base case
        int maxLength = 0;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(i);  // Push the index of the opening bracket
            } else {
                if (!stack.isEmpty() && (
                        (c == ')' && stack.peek() != -1 && S.charAt(stack.peek()) == '(') ||
                        (c == ']' && stack.peek() != -1 && S.charAt(stack.peek()) == '[') ||
                        (c == '}' && stack.peek() != -1 && S.charAt(stack.peek()) == '{'))) {
                    stack.pop();  // Pop the matching opening bracket
                    if (!stack.isEmpty()) {
                        maxLength = Math.max(maxLength, i - stack.peek());
                    }
                } else {
                    stack.push(i);  // Push the index of the unmatched closing bracket
                }
            }
        }
        return maxLength;
    
    }
}