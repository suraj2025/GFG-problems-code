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
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.Solve(n, nums);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> Solve(int n, int[] nums) {
        // code here
        int ele1=0;
        int ele2=0;
        int c1=0;
        int c2=0;
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(c1==0&& ele2!=nums[i]){
                c1=1;
                ele1=nums[i];
            }
            else if(c2==0&& ele1!=nums[i]){
                c2=1;
                ele2=nums[i];
            }
            else if(ele1==nums[i]) c1++;
            else if(ele2==nums[i]) c2++;
            else{
                c1--;
                c2--;
            }
        }

        int cnt=0;
        int cnt2=0;
        for(int num:nums){
            if(num==ele1) cnt++;
            else if(num==ele2) cnt2++;
        }
        if(cnt>nums.length/3) res.add(ele1);
        if(cnt2>nums.length/3) res.add(ele2);
        if(res.size()==0) res.add(-1);
        return res;
    }
}
        
