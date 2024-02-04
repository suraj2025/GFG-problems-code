//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
         Stack<Long> s = new Stack<Long>(); 
        
        long max_area = 0, area_with_top; 
        long tp=0, i = 0;
        
        //traversing the array.
        while (i < n) 
        { 
            if(!s.empty())tp=s.peek();
            if (s.empty() || hist[(int)tp] <= hist[(int)i]) {
                s.push(i++); 
            }
            else 
            { 
                tp = s.peek();
                s.pop(); 
                area_with_top=hist[(int)tp]*(s.empty() ? i : i-s.peek()-1); 
                if(max_area < area_with_top) 
                    max_area = area_with_top; 
            } 
        } 
        while (!s.empty()) 
        { 
            tp = s.peek(); 
            s.pop(); 
            area_with_top=hist[(int)tp]*(s.empty()? i : i-s.peek()-1);
            if (max_area < area_with_top) 
                max_area = area_with_top; 
        }
        return max_area; 
    }
        
}



