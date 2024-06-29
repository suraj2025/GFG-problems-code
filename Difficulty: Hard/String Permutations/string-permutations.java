//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
     void swap(char []str,int i,int j){
        char temp=str[i];
        str[i]=str[j];
        str[j]=temp;
    }
    void permutation(char []str,ArrayList<String> res,int fi,int n){
        if(fi==n-1){
            // if(!res.contains(new String(str))) 
            res.add(new String(str));
            return;
        }
        for(int i=fi;i<n;i++){
            swap(str,i,fi);
            permutation(str,res,fi+1,n);
            swap(str,i,fi);
        }
    }
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        ArrayList<String> res=new ArrayList<>();
        permutation(S.toCharArray(),res,0,S.length());
        Collections.sort(res);
        return res;
    }
	   
}
