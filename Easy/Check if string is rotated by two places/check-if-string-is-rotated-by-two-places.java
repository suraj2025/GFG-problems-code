//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    
		    Solution obj = new Solution();
		    
		    boolean flag = obj.isRotated(s1, s2);
		    
		    if(flag == true) System.out.println("1");
		    else System.out.println("0");
		    
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
    public static boolean isRotated(String str1, String str2)
    {
        // Your code here
        if(str1.length()==1||str2.length()==1)
        return false;
        int n = str1.length();
        String str3=str1.substring(2,n)+str1.substring(0,2);
        String str4=str1.substring(n-2,n) + str1.substring(0,n-2);
        // System.out.println(str3);
        // System.out.println(str4);
        if((str3.equals(str2)) || (str4.equals(str2))){
            return true;
        } return false;
        
     
        // return true;
    }
    
}