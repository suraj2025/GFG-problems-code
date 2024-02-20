//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> dictionary = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            dictionary.add(p);
                        }
                    String s = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(n, s, dictionary));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    private static boolean helper(String s,HashSet<String> hs){
        if(s==null || s=="" || hs.contains(s))
            return true;
        
        for(int i=1;i<s.length();i++){
            String part1 = s.substring(0,i);
            String part2 = s.substring(i);
            if(hs.contains(part1) && helper(part2,hs))
                return true;
        }
        return false;
    }
    
    public static int wordBreak(int n, String s, ArrayList<String> dictionary )
    {
        //code here
        HashSet<String> hs = new HashSet<>(dictionary);
        return helper(s,hs)?1:0;
    }
}