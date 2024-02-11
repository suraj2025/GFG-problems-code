//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPanagram(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPanagram(String str) {
        // code here
        str=str.toLowerCase();
   
        boolean check[]=new boolean[26];
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)-'a'>=0&&str.charAt(i)-'a'<26)
            check[str.charAt(i)-'a']=true;
        }
        for(int i=0;i<26;i++){
            if(!check[i]){
                return 0;
            }
        }
        return 1;
    }
};