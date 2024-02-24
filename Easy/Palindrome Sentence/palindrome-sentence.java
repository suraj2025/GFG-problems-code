//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
       public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while(t > 0){
            String str = sc.nextLine();
            Solution ob = new Solution();
            if(ob.sentencePalindrome(str))
                System.out.println(1);
            else
                System.out.println(0);
            t--;
        }
    } 
} 
// } Driver Code Ends


class Solution { 

    static boolean palindromeCheck(String s,int start,int end){
        if(start>=end){
            return true;
        }
        return (s.charAt(start)==s.charAt(end))&&palindromeCheck(s,start+1,end-1);
    }
    
    static boolean sentencePalindrome(String s) { 
        // code here
        s = s.replaceAll("\\s", "");
        // s = s.replaceAll(".", "");
        s = s.replaceAll(";", "");
        
        String op = s.replace(".","");
        boolean res=palindromeCheck(op,0,op.length()-1);
        return res;
    }
}