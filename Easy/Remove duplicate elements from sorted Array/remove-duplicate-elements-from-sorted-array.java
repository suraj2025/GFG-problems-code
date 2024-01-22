//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int a[] = new int[N];
            for(int i=0; i<N; i++)
                a[i] = sc.nextInt();
            
            Solution g = new Solution();
            int n = g.remove_duplicate(a,N);
            
            for(int i=0; i<n; i++)
                System.out.print(a[i]+" ");
            System.out.println();
            T--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int remove_duplicate(int A[],int N){
        // code here
        if (A.length == 0) {
            return 0;  // Handle empty array case
        }

        int writeIndex = 1;  // Index for writing unique elements

        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[writeIndex - 1]) {
                A[writeIndex] = A[i];
                writeIndex++;
            }
        }
       
        return writeIndex;
    }
}