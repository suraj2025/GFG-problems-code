//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
     static int noOfStudent(int arr[],long pages){
        int s=1;
        int page=0;
        for(int i=0;i<arr.length;i++){
            if(1L*page+arr[i]<=pages){
                page+=arr[i];
            }
            else{
                s++;
                page=arr[i];
            }
        }
        return s;
    }
    static long minTime(int[] nums,int n,int k){
        //code here
        long l=Integer.MIN_VALUE;
        long h=0;
        for(int num:nums){
            l=Math.max(l,num);
            h+=num;
        }

        while(l<=h){
            long mid=l+(h-l)/2;
            int s=noOfStudent(nums,mid);
            if(s<=k){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        } 
        return l;
    }
}


