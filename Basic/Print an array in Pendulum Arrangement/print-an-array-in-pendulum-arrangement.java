//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Compute obj = new Compute();
            int answer[] = obj.pendulumArrangement(arr, n);
            int sz = answer.length;

            StringBuilder output = new StringBuilder();
            for (int i = 0; i < sz; i++) output.append(answer[i] + " ");
            System.out.println(output);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Compute {
    public int[] pendulumArrangement(int arr[], int n) {
        // Write your code here
          Arrays.sort(arr);
        int arr2[] = new int[n];
        int i;
        
        if(n%2==0) {
            arr2[n/2-1] = arr[0];
            i = n/2-1;
        }
        else {
            i=n/2;
            arr2[n/2] = arr[0];
        }
        
        int j = 1;
        int k = 1;
        for(int count=0 ; count<n ; count++) {
            if(j%2!=0) {
                i=i+j;
                if(i<n)
                    arr2[i] = arr[k];
                k++;
                j++;
            }
            else {
                i=i-j;
                if(i>=0)
                    arr2[i] = arr[k];
                k++;
                j++;
            }
        }
        return arr2;
        
    }
}