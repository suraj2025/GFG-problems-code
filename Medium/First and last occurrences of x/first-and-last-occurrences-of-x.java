//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    int lowerBound(int arr[],int l,int h,int x){
        int res=h+1;
        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]>=x){
                res=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }
    int upperBound(int arr[],int l,int h,int x){
        int res=h+1;
        while(l<=h){
            int mid=(l+h)/2;
            if(arr[mid]>x){
                res=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return res;
    }
    ArrayList<Integer> find(int nums[], int n, int x)
    {
        // code here
        int f=lowerBound(nums,0,n-1,x);
        int l=upperBound(nums,0,n-1,x);
        if (f == n || nums[f] != x) 
        return new ArrayList<>(Arrays.asList(new Integer[]{-1, -1}));
        return new ArrayList<>(Arrays.asList(new Integer[]{f, l-1}));
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends