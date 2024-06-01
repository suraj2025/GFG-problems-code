//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        int[] freq = new int[27];
        for (int i = 0; i < s.length(); i++) {
            int position = s.charAt(i) - 'a' + 1;
            freq[position]++;
        }
        int sum = 0;
        for (int i = 1; i <= 26; i++) {
            if (freq[i] != 0) { 
                if (i % 2 == 0 && freq[i] % 2 == 0) {
                    sum++;
                } else if (i % 2 != 0 && freq[i] % 2 != 0) {
                    sum++;
                }
            }
        }
        return (sum % 2 == 0) ? "EVEN" : "ODD";
    }
}