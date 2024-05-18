//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int noOfStudent(int arr[],int pages){
        int s=1;
        int page=0;
        for(int i=0;i<arr.length;i++){
            if(page+arr[i]<=pages){
                page+=arr[i];
            }
            else{
                s++;
                page=arr[i];
            }
        }
        return s;
    }
    static int splitArray(int[] nums , int N, int k) {
        // code here
        if(k>N) return -1;
        int l=Integer.MIN_VALUE;
        int h=0;
        for(int num:nums){
            l=Math.max(l,num);
            h+=num;
        }

        while(l<=h){
            int mid=(l+h)/2;
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
};