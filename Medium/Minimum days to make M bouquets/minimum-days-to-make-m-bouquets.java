//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static boolean possible(int arr[],int day,int m,int k){
        int count=0;
        int noOfB=0;
        for(int num:arr){
            if(num<=day) count++;
            else{
                noOfB+=count/k;
                count=0;
            }
        }
        noOfB+=count/k;
        if(noOfB>=m) return true;
        return false;
    }
   
    public static int solve(int m, int k, int[] bloomDay) {
       int n=bloomDay.length;
        if(1L*m*k>n) return -1;
        int l=Integer.MAX_VALUE;
        int h=Integer.MIN_VALUE;
        for(int num:bloomDay){
            l=Math.min(l,num);
            h=Math.max(h,num);
        }

        while(l<=h){
            int mid=(l+h)/2;
            if(possible(bloomDay,mid,m,k)) h=mid-1;
            else l=mid+1;
        }
        return l;
    }
}