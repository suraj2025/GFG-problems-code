//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    boolean rows(int a[][],int row,int n){
        for(int j=0;j<n;j++){
    	        if(a[row][j]==1) return false;
    	    }
    	    return true;
    }
    boolean cols(int a[][],int col,int n){
        for(int j=0;j<n;j++){
    	        if(a[j][col]==0&&col!=j) return false;
    	    }
    	    return true;
    }
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	for(int i=0;i<n;i++){
    	    boolean flag=false;
    	    if(rows(M,i,n)){
    	        flag=cols(M,i,n);
    	    }
    	    if(flag) return i;
    	}
    	return -1;
    }
}