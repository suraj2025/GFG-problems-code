//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int M[][] = new int[N][N];
            String arr[] = in.readLine().trim().split("\\s+");
            for(int i = 0;i < N*N; i++)
                M[i/N][i%N] = Integer.parseInt(arr[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.distinct(M, N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int distinct(int M[][], int N)
    {
        // code here
        HashSet<Integer> s1=new HashSet<>();
        for(int num:M[0]){
            s1.add(num);
        }
        for(int i=1;i<N;i++){
            HashSet<Integer> s2=new HashSet<>();
            for(int num:M[i]){
                s2.add(num);
            }
            s1.retainAll(s2);
        
            
        }
        return s1.size();
    }
}