//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.findPair(n, x, arr);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    boolean binarySearch(int arr[],int l,int h,int x){
        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]==x) return true;
            else if(arr[mid]>x) h=mid-1;
            else l=mid+1;
        }
        return false;
    }
    public int findPair(int n, int x, int[] arr) {
        // code here
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
            if(binarySearch(arr,i+1,n-1,arr[i]+x)){
                return 1;
            }
        }
        return -1;
    }
}
