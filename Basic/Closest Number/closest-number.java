//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.closestNumber(N,M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
     static int closestNumber(int N , int M) {
        // code here
        int x =Math.abs(N/M);
        int n = Math.abs(N);
        int m = Math.abs(M);
        
        int diff = Math.abs(n-(x*m));
        int diff2 = Math.abs(n-((x+1)*m));
        
        if(diff == diff2){
            if(N<0){
                return -1*((x+1)*m);
            }else{
                return ((x+1)*m);
            }
        }
        
        if(N<0){
            if(diff<diff2){
                return -1*(x*m);
            }else{
                return -1*((x+1)*m);
            }
        }else{
            if(diff<diff2){
                return (x*m);
            }else{
                return ((x+1)*m);
            }
        }
        
    }
};