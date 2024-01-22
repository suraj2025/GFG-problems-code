//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            boolean ans = new Solution().hasArrayTwoCandidates(arr, n, x);
            System.out.println(ans ? "Yes" : "No");
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        // code here
        HashMap<Integer, Integer> countMap = new HashMap<>();
       int pairCount = 0;

      
       for (int num : arr) {
           countMap.put(num, countMap.getOrDefault(num, 0) + 1);
       }
       int c=0;
      
       for (int num : arr) {
           int complement = x - num;

           if (countMap.containsKey(complement)) {
               
              if (complement == num) {
               
                  pairCount --;  
              } 
            pairCount += countMap.get(complement);
              
              countMap.put(num,countMap.get(num)-1);
           }
        
       }

       return pairCount>0;
    }
}