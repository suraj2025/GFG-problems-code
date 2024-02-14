//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.rotate (n, d);
            System.out.println(res.get(0));
            System.out.println(res.get(1));
            
           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> rotate(int N, int D)
    {
        // your code here
         ArrayList<Integer> result = new ArrayList<>();
        D = D % 16;
        String binaryN = String.format("%16s", Integer.toBinaryString(N)).replace(' ', '0');
        String rotatedLeft = binaryN.substring(D) + binaryN.substring(0, D);
        String rotatedRight = binaryN.substring(16 - D) + binaryN.substring(0, 16 - D);
        int leftRotation = Integer.parseInt(rotatedLeft, 2);
        int rightRotation = Integer.parseInt(rotatedRight, 2);

        result.add(leftRotation);
        result.add(rightRotation);

        return result;
    }
}