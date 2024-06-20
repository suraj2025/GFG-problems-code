//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) arr[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.sumSubarrayMins(N, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int sumSubarrayMins(int N, int[] arr) {
        final int MOD = 1_000_000_007;

        int[] left = new int[N];
        int[] right = new int[N];
        Stack<int[]> st1 = new Stack<>();
        Stack<int[]> st2 = new Stack<>();
        
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            while (!st1.isEmpty() && st1.peek()[0] > arr[i]) {
                cnt += st1.peek()[1];
                st1.pop();
            }
            st1.push(new int[]{arr[i], cnt});
            left[i] = cnt;
        }
        
        for (int i = N - 1; i >= 0; i--) {
            int cnt = 1;
            while (!st2.isEmpty() && st2.peek()[0] >= arr[i]) {
                cnt += st2.peek()[1];
                st2.pop();
            }
            st2.push(new int[]{arr[i], cnt});
            right[i] = cnt;
        }
        
        long ans = 0;
        
        for (int i = 0; i < N; i++) {
            ans = (ans + (long) arr[i] * left[i] * right[i]) % MOD;
        }
        
        return (int) ans;
    }
}
