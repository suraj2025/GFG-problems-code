//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String A = sc.next();
                    String B = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.UncommonChars(A, B));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String UncommonChars(String A, String B)
    {
        // code here
        ArrayList<Character> ch=new ArrayList<>();
        String str="";
        for(int i=0;i<A.length();i++){
            if(!B.contains(A.charAt(i)+"")){
                str+=A.charAt(i);
            }
        }
        for(int i=0;i<B.length();i++){
            if(!A.contains(B.charAt(i)+"")){
                str+=B.charAt(i);
            }
        }
        for(int i=0;i<str.length();i++){
            if(!ch.contains(str.charAt(i))){
                ch.add(str.charAt(i));
            }
        }
        Collections.sort(ch);
        str="";
        for(int i=0;i<ch.size();i++){
            str+=ch.get(i);
        }
        if(str.length()==0){
            return "-1";
        }
        
        return str;
    }
}