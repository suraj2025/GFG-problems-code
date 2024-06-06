//{ Driver Code Starts
import java.util.*;

class Maxsum_Among_All_Rotations_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.println(new Solution().max_sum(arr, n));

            t--;
        }
    }
}

// } Driver Code Ends


class Solution {
    long max_sum(int a[], int n) {
        // Your code here
        long sum=0;
        long par=0;
        long val;
        for(int i=0;i<n;i++)
        {
            val=i;
            sum+=val*a[i];
            par+=a[i];
        }
        long res=sum;
        int k=n-1;
        long N=n;
        while(k>0)
        {
            sum=sum+par-(N*a[k]);
            res=Math.max(res,sum);
            k--;
        }
        return res;
    }
}
