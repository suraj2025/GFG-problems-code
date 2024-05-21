//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first+" "+ans.second);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    int firstoccurance(long arr[],long x){
        int l=0,h=arr.length-1;
        int res=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]==x){
                res=mid;
                h=mid-1;
            }
            else if(arr[mid]<x){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return res;
        
    }
    int lastOccurance(long arr[],long x){
        int l=0,h=arr.length-1;
        int res=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]==x){
                res=mid;
                l=mid+1;
            }
            else if(arr[mid]<x){
                l=mid+1;
            }
            else{
                h=mid-1;
            }
        }
        return res;
        
    }
    
    public pair indexes(long v[], long x)
    {
        // Your code goes here
        int left=firstoccurance(v,x);
        if(left==-1){
        return new pair(-1,-1);
            
        }
        int right=lastOccurance(v,x);
        return new pair(left,right);
        
    }
}