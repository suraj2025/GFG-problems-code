//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int count(int[] A, int mid, int n) {
    int l = 0, h = n - 1;
    while (l <= h) {
      int md = (l + h) >> 1;
      if (A[md] <= mid) {
        l = md + 1;
      } else {
        h = md - 1;
      }
    }
    return l;
  }
    int minimum(int mat[][]){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<mat.length;i++){
            min=Math.min(min,mat[i][0]);
        }
        return min;
    }
    int maximum(int mat[][]){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<mat.length;i++){
            max=Math.max(max,mat[i][mat[0].length-1]);
        }
        return max;
    }
    int median(int matrix[][], int R, int C) {
        // code here  
        int l=minimum(matrix);
        int h=maximum(matrix);
        int req=R*C/2;
        while(l<=h){
            int mid=(l+h)/2;
            int cnt = 0;
            for (int i = 0; i < R; i++) {
              cnt += count(matrix[i], mid, C);
            }
            if(cnt<=req){
                l=mid+1;
            }
            else h=mid-1;
        }
        
        return l;
    }
}