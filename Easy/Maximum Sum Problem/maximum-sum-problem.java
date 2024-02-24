//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSum(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
     public int maxSum(int n) 
    { 
        //code here.
        if(n<=0){
            return 0;
        }
        int div2 = n/2;
        int div3 = n/3;
        int div4 = n/4;
        
        int sumDiv2 = maxSum(div2);
        int sumDiv3 = maxSum(div3);
        int sumDiv4 = maxSum(div4);
        
        int maximumSum = sumDiv2 + sumDiv3 + sumDiv4;
        if(maximumSum < n){
        maximumSum = n;
        }
        return maximumSum;
    }
}
