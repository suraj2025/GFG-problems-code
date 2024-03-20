//{ Driver Code Starts
// Initial Template for Java

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
            System.out.println(ob.isGoodorBad(S));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int isGoodorBad(String s) {
        // code here
        int count =0 ;
        int vowel = 0;
       
       for(int i =0 ; i < s.length();i++){
           if(s.charAt(i) == 'a'||s.charAt(i) == 'e'||s.charAt(i) == 'i'||s.charAt(i) == 'o'||s.charAt(i) == 'u'){
               vowel++;
               count=0;
           }else if(s.charAt(i) == '?'){
               vowel++;
               count++;
           }else{
               count++;
               vowel=0;
               
           }
           
           if(vowel > 5 || count>3){
               return 0;
           }
       }
       return 1;
    }
};