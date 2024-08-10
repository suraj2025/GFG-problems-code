//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr, N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // int helper(int dp[][],int arr[][],int a,int day){
    //     if(day==0){
    //         int maxi=-1;
    //         for(int i=0;i<3;i++){
    //             if(i!=a){
    //                 maxi=Math.max(maxi,arr[0][i]);
    //             }
    //         }
    //         return dp[day][a]=maxi;
    //     }
    //     if(dp[day][a]!=-1) return dp[day][a];
    //     int maxi=-1;
    //     for(int i=0;i<3;i++){
    //         if(a!=i){
                
    //         int point=arr[day][i]+helper(dp,arr,i,day-1);
    //         maxi=Math.max(maxi,point);
    //         }
    //     }
    //     return dp[day][a]=maxi;
    // }
    public int maximumPoints(int arr[][], int N) {
        // code here
        int dp[][]=new int[N][4];
        dp[0][0]=Math.max(arr[0][1],arr[0][2]);
        dp[0][1]=Math.max(arr[0][0],arr[0][2]);
        dp[0][2]=Math.max(arr[0][1],arr[0][0]);
        dp[0][3]=Math.max(arr[0][0],Math.max(arr[0][1],arr[0][2]));
        for(int day=1;day<N;day++){
            for(int i=0;i<=3;i++){
                int maxi=-1;
                for(int j=0;j<3;j++){
                    if(i!=j){
                        
                    int point=arr[day][j]+dp[day-1][j];
                    maxi=Math.max(maxi,point);
                    }
                }
                dp[day][i]=maxi;
            }
        }
        return dp[N-1][3];
        
    }
}