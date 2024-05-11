//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int X = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.closest3Sum(Arr, N, X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int closest3Sum(int A[], int N, int X)
    {
        // code here
        int res=A[0]+A[1]+A[2];
        Arrays.sort(A);
        for(int i=0;i<N;i++){
            if(i>0&&A[i]==A[i-1]) continue;
            int l=i+1;
            int h=N-1;
            while(l<h){
                int triplet=A[i]+A[l]+A[h];
                if(Math.abs(triplet-X)<Math.abs(res-X)){
                    res=triplet;
                }
                if(triplet<X){
                    l++;
                }
                else{
                    h--;
                }
            }
        }
        return res;
    }
}