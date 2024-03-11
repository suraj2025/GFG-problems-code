//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.findGreatest(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public static int findGreatest(int arr[], int n)
    {
        // Your code goes here 
         Arrays.sort(arr);
       HashMap<Integer, Integer> map = new HashMap<>();
       for(int i = 0; i<n; i++) map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
       
       for(int i = n-1; i>1; i--){
            for(int j = 0; j<i && arr[j]<=Math.sqrt(arr[i]); j++){
                if(arr[i]%arr[j]==0){
                    int result = arr[i]/arr[j];
                    if(result!=arr[j] && map.containsKey(result)){
                        if(result==arr[i] ){
                                if(map.get(arr[i])>1) return arr[i];
                        }
                        else return arr[i];
                    }
                    else if (result == arr[j] && map.get(result) > 1) return arr[i];
                }
            }
       }
       return -1;
    }
}