//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaximum(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int findMaximum(int[] arr, int n) {
        // code here
        int l=1,h=n-2;
        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1]) return arr[mid];
            else if(arr[mid]>arr[mid-1]){
                l=mid+1;
            }
            else if(arr[mid]>arr[mid+1]){
                h=mid-1;
            }
        }
        if(h==1&&arr[0]>arr[h]) return arr[0];
        else if(h==n-2&&arr[n-1]>arr[h]) return arr[n-1];
        return arr[h];
    }
}