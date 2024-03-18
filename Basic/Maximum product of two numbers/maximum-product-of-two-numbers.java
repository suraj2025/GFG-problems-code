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
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().maxProduct(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int maxProduct(int arr[], int n) {
        // code here
        int max1=-1;
        int m=-1;
        int max2=-1;
        for(int i=0;i<n;i++){
            if(arr[i]>max1){
               
                max1=arr[i];
                m=i;
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i]>max2){
               if(arr[i]==max1&&i!=m){
                max2=arr[i];
               }
               if(arr[i]!=max1){
                max2=arr[i];
                   
               }
               
            }
        }
        // System.out.println(max1+" "+max2); 
        return max1*max2;
    }
}