//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.subarrayCount(a,n,k);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int atMostK(int[] arr, int N, int k) {
        if(k<0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, count = 0;
        for (int r = 0; r < N; r++) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            while (map.size() > k) {
                map.put(arr[l], map.get(arr[l]) - 1);
                if (map.get(arr[l]) == 0) {
                    map.remove(arr[l]);
                }
                l++;
            }
            count += r - l + 1;
        }
        return count;
    }
    static int subarrayCount(int arr[], int N, int k) {
    // code here
        
        return atMostK(arr,N,k)-atMostK(arr,N,k-1);

  }
}
     