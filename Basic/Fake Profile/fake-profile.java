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
                    String a = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.solve(a));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String solve(String a)
    {
        //code here
        String vow="aeiou";
        String check="";
        int count=0;
        for(int i=0;i<a.length();i++){
            if((!vow.contains(a.charAt(i)+""))&&(!check.contains(a.charAt(i)+""))){
                count++;
                check+=a.charAt(i);
            }
        }
        if(count%2==0){
            return "SHE!";
        }
        else{
            return "HE!";
        }
    }
}