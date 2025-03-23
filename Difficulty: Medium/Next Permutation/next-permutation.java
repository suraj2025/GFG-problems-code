//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// } Driver Code Ends

// User function Template for Java

class Solution {
    void reverse(int arr[],int l,int h){
        while(l<h){
            arr[l]=arr[l]+arr[h]-(arr[h]=arr[l]);
            l++;
            h--;
        }
    }
    void nextPermutation(int[] arr) {
        // code here
        int n=arr.length;
        int f=-1,l=-1;
        
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]) {
                f=i;
                break;
            }
        }
        if(f==-1) {
            reverse(arr,0,n-1);
            return;
        }
        for(int i=n-1;i>f;i--){
            if(arr[i]>arr[f]){
                l=i;
                break;
            }
        }
        arr[f]=arr[f]+arr[l]-(arr[l]=arr[f]);
        reverse(arr,f+1,n-1);
        
    }
}


//{ Driver Code Starts.

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ob.nextPermutation(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(arr[i] + " "); // Corrected: use arr[i] instead of arr.get(i)
            }
            System.out.println(out.toString().trim()); // Print the output

            System.out.println("~");
        }
    }
}
// } Driver Code Ends