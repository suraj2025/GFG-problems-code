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
                    String s = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.removeConsonants(s));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String removeConsonants(String s)
    {
        //code here.
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()){
            if("aeiouAEIOU".indexOf(c)>=0) sb.append(c);
        }
        
    return sb.toString().isEmpty()?"No Vowel":sb.toString();
    }
    
}
