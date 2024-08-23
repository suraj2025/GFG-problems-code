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
            ArrayList<ArrayList<Integer> > triangle= new ArrayList<ArrayList<Integer> >(n);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer>temp=new ArrayList<Integer>();
                for(int j=0;j<=i;j++){
                    int x=sc.nextInt();
                    temp.add(x);
                }
                triangle.add(temp);
            }
            Solution obj = new Solution();
            int ans = obj.minimizeSum(n, triangle);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >grid) {
        // Code here
       
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=grid.get(n-1).get(i);
        }
        
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int down=grid.get(i).get(j)+dp[j];
                int diag=grid.get(i).get(j)+dp[j+1];
                dp[j]=Math.min(down,diag);
            }
        }
        return dp[0];
    }
}