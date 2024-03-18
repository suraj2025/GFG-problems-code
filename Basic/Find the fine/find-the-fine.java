//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG {
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long k = Long.parseLong(stt.nextToken());
            
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            long b[] = new long[(int)(n)];
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(inputLine1[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.totalFine(n, k, a, b));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long totalFine( long n, long date, long car[], long fine[])
    {
        HashMap<Integer,Long> map=new HashMap<>();
        for(int i=0;i<(int)n;i++){
            int pos=(int)car[i]%2;
            if(map.containsKey(pos)){
                
                map.put(pos,map.get(pos)+fine[i]);
            }
            else{
                map.put(pos,fine[i]);
                
            }
        }
        int pos=(int)date%2==0?1:0;
        if(map.containsKey(pos)) return map.get(pos);
        return 0;
    }
}