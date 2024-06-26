//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int nums[]){
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        int b=-1,c=-1;
        int l=0,h=nums.length-1;
        for(int i=h-1;i>=0;i--){
            if(nums[i]<nums[i+1]){
                b=i;
                break;
            }
        }
        if(b==-1){
            while(l<h){
            int temp1=nums[l];
            nums[l]=nums[h];
            nums[h]=temp1;
            l++;
            h--;
           }
           for(int e:nums){
            res.add(e);
        }
           return res;
        }
        for(int i=h;i>=b+1;i--){
            if(nums[i]>nums[b]){
                c=i;
                break;
            }
        }
        int temp=nums[b];
        nums[b]=nums[c];
        nums[c]=temp;
        l=b+1;
        while(l<h){
            int temp1=nums[l];
            nums[l]=nums[h];
            nums[h]=temp1;
            l++;
            h--;
        }
        for(int e:nums){
            res.add(e);
        }
        return res;
    }
}

