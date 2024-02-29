//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine());
		    String inputLine[] = br.readLine().trim().split(" ");
		    int arr[] = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i]=Integer.parseInt(inputLine[i]);
		    }
		    Solution obj = new Solution();
		    
		    System.out.println(obj.maxAND(arr, n));
		}
	}
}

// } Driver Code Ends



class Solution{
     public static int max(int[] arr,int mask){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if((mask&arr[i])==mask){
                count++;
            }
        }
        return count;
    }
    // Function for finding maximum and value pair
    public static int maxAND (int arr[], int n) {
        // Complete the function
         int mask=0;
        int result=0;
        for(int i=31;i>=0;i--){
            mask=(result|(1<<i));
            int count=max(arr,mask);
            if(count>=2){
                result=result|mask;
            }
        }
        return result;
    }
    
    
    
}
