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
      int target = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      
      Solution obj = new Solution();
      int ans = obj.numberOfSubarrays(a, n, target);
      System.out.println(ans);
    }
  }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{  
    int sumLE(int arr[],int k,int N){
        if(k<0) return 0;
        int l=0,cnt=0,sum=0;
        for(int r=0;r<N;r++){
            sum+=arr[r];
            while(sum>k){
                sum-=arr[l];
                l++;
            }
            cnt+=r-l+1;
        }
        return cnt;
    }
    int numberOfSubarrays(int arr[], int N, int target){
        // code here
        return sumLE(arr,target,N)-sumLE(arr,target-1,N);
    }
}