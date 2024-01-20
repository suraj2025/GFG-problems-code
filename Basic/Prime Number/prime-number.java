//{ Driver Code Starts
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
            System.out.println(ob.isPrime(N));
        }
    }
}
// } Driver Code Ends


class Solution{
    static int isPrime(int N){
        // code here
        if (N <= 1) {
            return 0; 
        }
        if (N <= 3) {
            return 1; 
        }

        
        if (N % 2 == 0 || N % 3 == 0) {
            return 0;
        }

        // Check divisibility from 6k ± 1 up to the square root of n
        for (int i = 5; i * i <= N; i += 6) {
            if (N % i == 0 || N % (i + 2) == 0) {
                return 0;
            }
        }

        return 1;
    }
}