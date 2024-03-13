//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] matrixDiagonally(int[][] arr) {
        Map<Integer, List<Integer>> m = new HashMap<>(); // Store elements in the map based on diagonal index 
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int diagonalIndex = i + j; 
                if (!m.containsKey(diagonalIndex)) { 
                    m.put(diagonalIndex, new ArrayList<>()); 
                    
                } 
                    m.get(diagonalIndex).add(arr[i][j]); 
                
            } 
            
        }
        List<Integer> result = new ArrayList<>(); 
        int k = 0; // Traverse the map and append elements to result list 
        for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) {
            if (k % 2 == 0 && k > 0) { 
                Collections.reverse(entry.getValue()); 
                
            } 
            result.addAll(entry.getValue()); 
            k++; 
            
        } // Convert List<Integer> to int[] 
        int[] res = new int[result.size()]; 
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
            } 
            return res; 
    }
}