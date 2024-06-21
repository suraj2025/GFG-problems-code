//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends




class Solution {
    public static long getMaxArea(long[] heights, long N) {
        Stack<int[]> leftStack = new Stack<>();
        Stack<int[]> rightStack = new Stack<>();
        int[] left = new int[(int)N];
        int[] right = new int[(int)N];
        
        // Calculate left array
        for (int i = 0; i < N; i++) {
            int count = 1;
            while (!leftStack.isEmpty() && leftStack.peek()[0] > heights[i]) {
                count += leftStack.peek()[1];
                leftStack.pop();
            }
            leftStack.push(new int[]{(int)heights[i], count});
            left[i] = count;
        }
        
        // Calculate right array
        for (int i = (int)N - 1; i >= 0; i--) {
            int count = 1;
            while (!rightStack.isEmpty() && rightStack.peek()[0] >= heights[i]) {
                count += rightStack.peek()[1];
                rightStack.pop();
            }
            rightStack.push(new int[]{(int)heights[i], count});
            right[i] = count;
        }
        
        // Calculate maximum area
        long maxArea = 0;
        for (int i = 0; i < N; i++) {
            long area = heights[i] * (left[i] + right[i] - 1);
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
}




