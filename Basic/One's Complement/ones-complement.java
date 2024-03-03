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
            System.out.println(ob.onesComplement(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int onesComplement(int N){
        //code here
        // if(N==1){
        //     return 0;
        // }
        int result = (int)(Math.log(N) / Math.log(2));
        
        result++;
        
        int res=(int)Math.pow(2,result);
       
        res=(res-1)^N;
        return res;
    }
}