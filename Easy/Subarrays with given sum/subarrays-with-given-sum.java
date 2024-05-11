//{ Driver Code Starts
import java.util.*; 
import java.lang.*;
import java.io.*;




class Array
 {
	public static void main (String[] args)
	 {
	 Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 while(t-->0)
	    {
	    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++)
		    {
		        arr[i] = sc.nextInt();
		    }
		    int sum = sc.nextInt();
		    Solution ob=new Solution();
		    System.out.println(ob.subArraySum(arr,n,sum));
		}
	}
}


// } Driver Code Ends


class Solution
{ 
    public static int subArraySum(int[] Arr, int N, int k)
    { 
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        int preSum = 0;
        int count = 0;
        prefixSums.put(0,1);
        for (int i = 0; i < N; i++) {
            preSum += Arr[i];
            if (prefixSums.containsKey(preSum - k)) {
                count += prefixSums.get(preSum - k);
            }
            prefixSums.put(preSum, prefixSums.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }
}
  