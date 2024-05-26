//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int mat[][] = new int[n][m];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                  mat[i][j] = sc.nextInt();
            }
            
            int x = sc.nextInt();
            
            System.out.println (new Sol().matSearch(mat, n, m, x));
        }
        
    }
}
// } Driver Code Ends


class Sol
{
    static int binarySearch(int arr[],int l,int h,int X){
        while(l<=h){
            int mid=(l+h)/2;
           
            if(arr[mid]==X) return 1;
            else if(arr[mid]>X) h=mid-1;
            else l=mid+1;
        }
        return 0;
        
    }
    public static int matSearch(int mat[][], int N, int M, int X)
    {
        // your code here
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(mat[i][j]==X){
                    return 1;
                }
            }
        }
        return 0;
    }
}