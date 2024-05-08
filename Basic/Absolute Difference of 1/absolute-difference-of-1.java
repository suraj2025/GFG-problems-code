//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            long k = Long.parseLong(inputLine[1]);
            long[] arr = new long[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            long[] ans = new Solution().getDigitDiff1AndLessK(arr, n, k);
            for (long ele : ans) {
                System.out.print(ele + " ");
            }
            if (ans.length == 0) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    long[] getDigitDiff1AndLessK(long[] arr, int n, long k) {
        // code here
        ArrayList<Long> result=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(arr[i]<k)
            {
                if(yesno(arr[i])==true)
                {
                    result.add(arr[i]);
                }
            }
        }
        long ans[]=new long[result.size()];
        for(int i=0;i<result.size();i++)
        {
            ans[i]=result.get(i);
        }
        return ans;
    }
    boolean yesno(long a)
    {
        ArrayList<Long> v=new ArrayList<>();
        while(a>0)
        {
            long d=a%10;
            v.add(d);
            a=a/10;
        }
        if(v.size()==1)
        {
            return false;
        }
        for(int i=0;i<v.size()-1;i++)
        {
            if(Math.abs(v.get(i)-v.get(i+1))!=1)
                return false;
        }
        return true;
    }
}