//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
{
	public static void main (String[] args) throws IOException
	{
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 int tc=Integer.parseInt(br.readLine().trim());
	 
	 while(tc-- >0)
	 {
	     String line=br.readLine().trim();
	     
	     Solution obj = new Solution();
	     
	     System.out.println(obj.getMaxOccuringChar(line));
	     
	 }
	 }
}
// } Driver Code Ends



class Solution
{
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String line)
    {
        // Your code here
        int[] frequency = new int[26]; // Assuming lowercase English alphabets

        // Count the frequency of each character in the string
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            frequency[ch - 'a']++;
        }

        char maxChar = 'a'; // Initialize with 'a' (lexicographically smaller)
        int maxCount = 0;

        // Find the character with the maximum frequency
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (frequency[ch - 'a'] > maxCount) {
                maxCount = frequency[ch - 'a'];
                maxChar = ch;
            }
        }

        return maxChar;
    }
    
}