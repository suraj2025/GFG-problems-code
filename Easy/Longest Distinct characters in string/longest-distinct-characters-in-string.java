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
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        HashSet<Character> hs=new HashSet<>();
        int r=0;
        int l=0;
        int max=0;
        for(r=0;r<S.length();r++){
            char current_character=S.charAt(r);
            while(hs.contains(current_character)){
                hs.remove(S.charAt(l));
                l++;
            }
            hs.add(current_character);
            max=Math.max(max,r-l+1);
        }
        return max;
        
    }
}