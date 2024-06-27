//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String s) {
        // Your code goes here
        int map[]=new int[256];
        int n=0;
        for(char ch:s.toCharArray()){
            if(map[ch]==0) {
                
            map[ch]++;
            n++;
            }
        }

        int l=0,minLen=Integer.MAX_VALUE,cnt=0;
        for(int r=0;r<s.length();r++){
            if(map[s.charAt(r)]>0) cnt++;
            map[s.charAt(r)]--;

            while(cnt==n){
                if(r-l+1<minLen){
                  
                minLen=r-l+1;
                } 
                 map[s.charAt(l)]++;
                if (map[s.charAt(l)] > 0) {
                    cnt--;
                }
                l++;

            }
        }
       return  minLen;
    }
}