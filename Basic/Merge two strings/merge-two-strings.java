//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            String S1 = input_line[0];
            String S2 = input_line[1];
            Solution ob = new Solution();
            System.out.println(ob.merge(S1,S2));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String merge(String s1, String s2)
    { 
        // code here
         StringBuilder stringBuilder = new StringBuilder();
        int loopTimes = Math.max(s1.length(),s2.length());
        // QehyNFX
        int s1Count = 0;
        int s2Count = 0;

        for (int i =0; i < loopTimes; i++) {
            // 0 < 2
             if(s1Count < s1.length()) {
                 stringBuilder.append(s1.charAt(s1Count));
                 s1Count++;
             }

            if(s2Count < s2.length()) {
                stringBuilder.append(s2.charAt(s2Count));
                s2Count++;
            }
        }
        return stringBuilder.toString();
    }
} 