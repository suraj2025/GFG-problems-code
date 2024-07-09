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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.canRepresentBST(arr, N));
        }
    }
}
// } Driver Code Ends



class Solution {
    int canRepresentBST(int arr[], int N) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;

        // Traverse given array
        for (int i = 0; i < N; i++) {
            // If we find a node who is on the right side
            // and smaller than root, return 0
            if (arr[i] < root) {
                return 0;
            }

            // If arr[i] is in the right subtree of stack top,
            // Keep removing items smaller than arr[i]
            // and make the last removed item as new root.
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                root = stack.pop();
            }

            // At this point either stack is empty or
            // arr[i] is smaller than root, push arr[i]
            stack.push(arr[i]);
        }
        return 1;
    }
}
