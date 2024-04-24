//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
     public static int wayss(int n, int m,int [][]dp)
    {
        // complete the function
        if(n == 0 && m == 0)
        {
             dp[0][0] = 1;
             return dp[0][0];
        }
        
        if(n < 0 || m < 0)
        {
            return 0;
        }
        
        if(dp[n][m] != -1)
        {
            return dp[n][m];
        }
        
        dp[n][m] = (wayss(n-1,m,dp)+wayss(n,m-1,dp))%1000000007;
        
        return dp[n][m];
    }
    
    public static int ways(int n, int m)
    {
        // complete the function
        int dp[][] = new int[n+1][m+1];
        for(int i = 0 ; i< n+1 ; i++)
        {
            Arrays.fill(dp[i],-1);
        }
        
       return wayss(n,m,dp);
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    int x=Integer.parseInt(elements[0]);
		    int y=Integer.parseInt(elements[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.ways(x,y));
		}
	}
}
// } Driver Code Ends