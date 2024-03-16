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

            new Solution().segregateEvenOdd(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java




class Solution {
    
    void segregateEvenOdd(int arr[], int n) {
        // code here
          
       int i=0,j=n-1;
       
      while(i<j)
      {
          while(i<n && arr[i]%2==0)
          i++;
          
          while(j>0 && arr[j]%2!=0)
          j--;
          
          if(i<j)
          swap(arr,i,j);
          
      }
      
      Arrays.sort(arr,0,i);
      Arrays.sort(arr,i,n);
       
    }
    
    void swap(int arr[],int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
}