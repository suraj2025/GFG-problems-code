//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int countDays(int arr[],int cap){
        int day=1,load=0;
        for(int num:arr){
            if(load+num>cap){
                day++;
                load=num;
            }
            else{
                load+=num;
            }
        }
        return day;
    }
    static int leastWeightCapacity(int[] weights, int n, int days) {
        // code here
        
        int l = Integer.MIN_VALUE, h = 0;
        for(int num:weights){
            l=Math.max(l,num);
            h+=num;
        }
        
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int d = countDays(weights, mid);
            if (d <= days) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
};