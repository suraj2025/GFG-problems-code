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
            long res = obj.subarrayRanges(N, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long sumSubarrayMins(int[] arr) {
        int N=arr.length;
        

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
            ans +=1L*arr[i]*left[i]*right[i];
        }
        
        return ans;
    }
    public static long sumSubarrayMaxs(int[] arr) {
        int N=arr.length;
        

        int[] left = new int[N];
        int[] right = new int[N];
        Stack<int[]> st1 = new Stack<>();
        Stack<int[]> st2 = new Stack<>();
        
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            while (!st1.isEmpty() && st1.peek()[0] < arr[i]) {
                cnt += st1.peek()[1];
                st1.pop();
            }
            st1.push(new int[]{arr[i], cnt});
            left[i] = cnt;
        }
        
        for (int i = N - 1; i >= 0; i--) {
            int cnt = 1;
            while (!st2.isEmpty() && st2.peek()[0] <= arr[i]) {
                cnt += st2.peek()[1];
                st2.pop();
            }
            st2.push(new int[]{arr[i], cnt});
            right[i] = cnt;
        }
        
        long ans = 0;
        
        for (int i = 0; i < N; i++) {
            ans +=1L*arr[i]*left[i]*right[i];
        }
        
        return ans;
    }
    public static long subarrayRanges(int N, int[] nums) {
        // code here
        return sumSubarrayMaxs(nums)-sumSubarrayMins(nums);
    }
}
