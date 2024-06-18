//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {
    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here
         StringBuilder str = new StringBuilder();
        Stack<Character> st = new Stack<>();
        // Operator precedence map
        String operators = "+-*/^";
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                str.append(ch);
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    str.append(st.pop());
                }
                st.pop(); // Pop '(' from stack
            } else if (operators.indexOf(ch) != -1) {
                while (!st.isEmpty() && precedence(st.peek()) >= precedence(ch)) {
                    str.append(st.pop());
                }
                st.push(ch);
            }
        }
        // Pop all the operators from the stack
        while (!st.isEmpty()) {
            str.append(st.pop());
        }
        return str.toString();
    }
}