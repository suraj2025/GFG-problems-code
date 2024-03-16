//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] entry=new int[n];
			for(int i=0;i<n;i++)
				entry[i]=sc.nextInt();
			int[] exit=new int[n];
			for(int i=0;i<n;i++)
				exit[i]=sc.nextInt();
			Solution ob= new Solution();
			int[] res=ob.findMaxGuests(entry,exit,n);
			for(int i=0;i<2;i++){
				System.out.print(res[i]);
			    System.out.print(" ");
			}
			System.out.println();
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int[] findMaxGuests(int[] Entry,int Exit[], int n){
        // add code here.
        
        Arrays.sort(Entry);
        Arrays.sort(Exit);
         // guests_in indicates number of guests at a time
        int guests_in = 1, max_guests = 1, time = Entry[0];
        int i = 1, j = 0;
        while (i < n && j < n)
        {
            if (Entry[i] <= Exit[j])
            {
                guests_in++;
                if (guests_in > max_guests)
                {
                    max_guests = guests_in;
                    time = Entry[i];
                }
                i++; 
            }
            else 
            { 
                guests_in--;
                j++;
            }
        }
        return new int[]{max_guests,time};
	}
}