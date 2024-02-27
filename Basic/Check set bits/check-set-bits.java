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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isBitSet(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int isBitSet(int N){
        //code here
        if (N == 0) {
            return 0;
        }
        
        // Count the number of bits in N
        int numBits = (int) (Math.log(N) / Math.log(2)) + 1;
        
        // If the number is a power of 2, return true
        if(N==(1 << numBits) - 1){
            return 1;
        }
        
        return 0;
    }
}