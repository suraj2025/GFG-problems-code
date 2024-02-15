//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.ReverseSort(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    //  static int MAX_CHAR = 26;
    String ReverseSort(String str) 
    { 
        // code here
           char[] charArray = str.trim().toCharArray();
        Arrays.sort(charArray);
        StringBuilder sb = new StringBuilder();
        for (int i = charArray.length-1; i >= 0; i--) {
            sb.append(charArray[i]);
        }
        return sb.toString();
    }
} 