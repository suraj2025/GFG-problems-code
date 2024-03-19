//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t > 0){
            String S = sc.nextLine();
            Solution ob = new Solution();
            System.out.println(ob.extractMaximum(S)); 
            t--;
        }
    } 
} 



// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int extractMaximum(String S) 
    { 
        // code here
        int max=-1;
        String str="";
        for(char c:S.toCharArray()){
            if(c-'0'>=0&&c-'0'<10){
                str+=c;
            }
            else{
                if(str.length()!=0){
                
                max=Math.max(max,Integer.parseInt(str));
                str="";
                }
            }
        }
        if(str.length()!=0){
                
                max=Math.max(max,Integer.parseInt(str));
                str="";
        }
        return max;
    }    
} 
