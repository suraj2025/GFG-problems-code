//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		while(testcases-- > 0){
		    
		    int n = Integer.parseInt(br.readLine());
		    int arr[] = new int[n];
		    
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split(" ");
		    
		    for(int index = 0;index < n; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Check obj = new Check();
		    
		    System.out.println(obj.lastSeenElement(arr,n));
		        
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java

class Check{
    
    static int lastSeenElement(int arr[], int n) 
    { 
        // Complete the function 
          Map<Integer, Integer> a = new HashMap<>();
        for(int i=0; i<n; i++){
            a.put(arr[i],i);
        }
        
        int ans=0; int max=n;
        for(int i=0; i<n; i++){
            if(a.get(arr[i])<max){
                max = a.get(arr[i]);
                ans = arr[i];
            }
        }
        return ans;
    } 
}

