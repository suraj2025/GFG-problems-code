//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        
        while(t--!=0){
            String s1=in.next(),
                   s2=in.next();
            
            Solution obj = new Solution();
            
            System.out.println(obj.concatenatedString(s1,s2));
        }
    }
}

// } Driver Code Ends




class Solution
{
    //Function to remove common characters and concatenate two strings.
    public static String concatenatedString(String s1,String s2)
    {
        // Your code here
        String str1="";
        String str2="";
        for(int i=0;i<s1.length();i++){
            if(!s2.contains(s1.charAt(i)+"")){
                str1+=s1.charAt(i);
            }
        }
        for(int i=0;i<s2.length();i++){
            if(!s1.contains(s2.charAt(i)+"")){
                str2+=s2.charAt(i);
            }
        }
        if((str1+str2).length()==0){
            return "-1";
        }
        return str1+str2;
        
    }
}
