//{ Driver Code Starts
//Initial Template for Java

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
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        HashMap<Character,Integer> map=new HashMap<>();
        int l=0,r=0;
        int maxLen=0;
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            if(map.containsKey(ch)&&map.get(ch)>=l){
                l=map.get(ch)+1;
            }
            maxLen=Math.max(maxLen,i-l+1);
            map.put(ch,i);
        }
        return maxLen;
    }
}