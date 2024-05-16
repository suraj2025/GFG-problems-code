//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    int binarySearch1(int arr[],int l,int h,int x){
        int res=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]==x){
                res=mid;
                h=mid-1;
            }
            else if(arr[mid]>x){
                h=mid-1;}
            else{
                l=mid+1;
            }
        }
        return res;
    }
    int binarySearch2(int arr[],int l,int h,int x){
        int res=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]==x){
                res=mid;
                l=mid+1;
            }
            else if(arr[mid]>x){
                h=mid-1;}
            else{
                l=mid+1;
            }
        }
        return res;
    }
    int count(int[] nums, int n, int x) {
        // code here
        int f=binarySearch1(nums,0,n-1,x);
        if(f==-1){
            return 0;
        }
        int l=binarySearch2(nums,0,n-1,x);
        return l-f+1;
    }
}