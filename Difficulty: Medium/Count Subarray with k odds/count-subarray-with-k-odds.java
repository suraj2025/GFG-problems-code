//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] nums = IntArray.input(br, n);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.countSubarray(n, nums, k);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    static int sumLE(int arr[],int k,int N){
        if(k<0) return 0;
        int l=0,cnt=0,sum=0;
        for(int r=0;r<N;r++){
            if(arr[r]%2!=0) sum+=1;
            while(sum>k){
            if(arr[l]%2!=0) sum-=1;
                
                l++;
            }
            cnt+=r-l+1;
        }
        return cnt;
    }
    public static int countSubarray(int n, int[] arr, int k) {
        // code here
        return sumLE(arr,k,n)-sumLE(arr,k-1,n);
    }
}
        
