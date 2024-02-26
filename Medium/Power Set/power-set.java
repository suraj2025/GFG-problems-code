//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    void subset(String s,String curr,int i,ArrayList<String>a){
        if(i==s.length()){
            if(curr.length()==0) return;
            a.add(curr);
            return;
        }
        subset(s,curr,i+1,a);
        subset(s,curr+s.charAt(i),i+1,a);
    }
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        ArrayList<String> a=new ArrayList<>();
        subset(s,"",0,a);
        Collections.sort(a);
        return a;
    }
}