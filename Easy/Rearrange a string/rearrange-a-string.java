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
                    Solution obj = new Solution();
                    System.out.println(obj.arrangeString(s));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String arrangeString(String s)
        {
            //code here.
            String str="";
            int num=0;
            for(int i=0;i<s.length();i++){
                if(Character.isDigit(s.charAt(i))){
                    num+=s.charAt(i)-'0';
                }
                else{
                    str+=s.charAt(i);
                }
            }
            char charArray[] = str.toCharArray();
            Arrays.sort(charArray);
            if(str.length()==s.length()){
                
            return new String(charArray);
            }
            
            return new String(charArray)+num;
            
        }
}
