//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        Long t = Long.parseLong(read.readLine());
        while(t-- > 0)
        {
            long N = Long.parseLong(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isPallindrome(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static String toBinary(long n){
        // code here
        
        String s="";
        while(n>0){
            s=n%2+s;
            n/=2;
        }
       return s; 
    }
    static long isPallindrome(long N){
        // code here
        String s=toBinary(N);
        int st=0,end=s.length()-1;
    
        while(st<end){
            if(s.charAt(st)!=s.charAt(end)){
                return 0;
            }
            st++;
            end--;
        }
        return 1;
    }
}