//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int N = sc.nextInt();
                    int Arr[] = new int[N];
                    for(int i = 0;i<N;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.gcd(N,Arr));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int GCD(int a, int b)
    {
        // find and return GCD of two numbers;
        if(b==0) return a;
        return GCD(b,a%b);
    }
    public int gcd(int N , int arr[]) 
    { 
       //code here.
    //   Array.sort(arr);
       if(N==1){
           return arr[0];
       }
    //   int res=1;
       int res=GCD(arr[0],arr[1]);
       for(int i=2;i<N;i++){
           res=GCD(arr[i],res);
       }
       return res;
       
    } 
}