//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
        	int n = sc.nextInt();
        	int[] array = new int[n];
        	for(int i=0; i<n; i++)
        	{
        		array[i] = sc.nextInt();
        	}
        	int target = sc.nextInt();

            Solution ob = new Solution();
			System.out.println(ob.Search(array,target));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int Search(int array[], int target)
	{
	    // code here
	     int left=0, right = array.length-1;
	    
	    while(left<=right)
	    {
	        int mid = left+right >> 1;
	        
	        if(array[mid] == target) return mid;
	        
	        if(array[left] <= array[mid])
	        {
	            if(array[left] <= target && target < array[mid])
	                right = mid-1;
	            else  
	                left = mid+1;
	        }
	        
	        if(array[mid] <= array[right])
	        {
	            if(array[mid] < target && target <= array[right])
	                left = mid+1;
	            else
	                right = mid-1;
	        }
	    }
	    
	    return -1;
	}
} 

