//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int n = a1.length;
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }

            String line2 = br.readLine();
            String[] a2 = line2.trim().split("\\s+");
            n = a2.length;
            int b[] = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = Integer.parseInt(a2[i]);
            }

            int ans = new Solution().maxMeetings(a, b);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        // add your code here
        ArrayList<int[]> arr=new ArrayList<>();
        
        for(int i=0;i<start.length;i++){
            arr.add(new int[]{i,start[i],end[i]});
        }
        
        Collections.sort(arr,(int[] a,int[] b)->a[2]-b[2]);
        
        
        // int st=arr.get(0)[1];
        ArrayList<Integer> res=new ArrayList<>();
        int et=arr.get(0)[2];
        res.add(arr.get(0)[0]);
        for(int i=1;i<start.length;i++){
            int a[]=arr.get(i);
           if(a[1]>et){
               res.add(a[0]);
               et=a[2];
           }
        }
        return res.size();
    }
}
