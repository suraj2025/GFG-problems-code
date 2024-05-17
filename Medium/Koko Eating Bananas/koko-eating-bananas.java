//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;
        int n = v.length;
        
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, v[i]);
        }
        return maxi;
    }
    
    static int time(int[] piles, int mid, int n) {
        int t = 0;
        for (int i = 0; i < n; i++) {
            t+=Math.ceil((double) piles[i] / mid);
        }
        return t;
    }
    
    
    public static int Solve(int N, int[] piles, int H) {
        // code here
        int l = 1, h = findMax(piles);
        
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int total = time(piles, mid,N );
            if (total <= H) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
        
