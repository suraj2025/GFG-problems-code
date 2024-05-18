//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static boolean canPlace(int arr[],int dist,int cows){
        int cnt=1;
        int last=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-last>=dist){
                cnt++;
                last=arr[i];
            }
            if(cnt>=cows) return true;
        }
        return false;
    }
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);
        int l=1,h=stalls[n-1]-stalls[0];
        while(l<=h){
            int mid=(l+h)/2;
            if(canPlace(stalls,mid,k)){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return h;
    }
}