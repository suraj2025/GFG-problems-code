//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		
	    while(t-- >0)
	    {
	        String inputLine[] = br.readLine().trim().split(" ");
	        
	        //taking n and sum
            int n = Integer.parseInt(inputLine[0]);
            int sum = Integer.parseInt(inputLine[1]);
            
            //calling largestNumber() function
            System.out.println(new Solution().largestNumber(n, sum));
	    }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to return the largest possible number of n digits
    //with sum equal to given sum.
    static String largestNumber(int N, int S)
    {
        // add your code here
        if(S>9*N){
            return "-1";
        }
        String s="";
        for(int i=0;i<N;i++){
            if(S>=9){
                
            s+=9;
            S=S-9;
            }
            else{
               s+=S;
                S=0;
            }
        }
        
        return s;
    }
}


