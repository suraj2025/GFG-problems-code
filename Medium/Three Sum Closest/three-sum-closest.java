//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int target = sc.nextInt();
        	int[] array = new int[n];
        	for(int i=0; i<n; i++)
        		array[i] = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.threeSumClosest(array,target));
            t--;
        }
    } 
} 

// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int threeSumClosest(int[] A, int X)  
	{ 
        int res=A[0]+A[1]+A[2];
        int N=A.length;
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
                else if(Math.abs(triplet-X)==Math.abs(res-X)){
                    res=Math.max(res,triplet);
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
