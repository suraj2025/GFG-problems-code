//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            long N=sc.nextLong();
			
            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for(long num : ans){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static void fact(ArrayList<Long> res,long N,long f,int c){
        if(f>N) return;
        res.add(f);
        c++;
        f=f*c;
        fact(res,N,f,c);
    } 
    static ArrayList<Long> factorialNumbers(long N){
        // code here
        ArrayList<Long> res=new ArrayList<>();
        fact(res,N,(long)1,1);
        return res;
    }
}