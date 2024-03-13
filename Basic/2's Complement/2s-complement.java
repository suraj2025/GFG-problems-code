//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String bi = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.complement(bi));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String complement(String bi){
        // code here
         char [] ch=bi.toCharArray();
        
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]=='0')
            {
                ch[i]='1';
            }
            else
            ch[i]='0';
        }
        
        for(int i=ch.length-1;i>=0;i--)
        {
            if(ch[i]=='0')
            {
                ch[i]='1';
                break;
            }
            else
            {
                ch[i]='0';
            }
        }
        return new String(ch);
    }
}