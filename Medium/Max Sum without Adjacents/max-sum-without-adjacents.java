//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
   
    int findMaxSum(int arr[], int n) {
        // code here
        int p1=0;
        int p2=arr[0];
        for(int i=1;i<n;i++){
            int pick=arr[i];
            if(i>1) pick+=p1;
            int notPick=0+p2;
            int curr=Math.max(pick,notPick);
            p1=p2;
            p2=curr;
        }
        return p2;
    }
}