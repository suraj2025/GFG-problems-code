//{ Driver Code Starts
//Initial Template for Java



//Initial Template for Java



import java.io.*;
import java.util.*;


class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
//            String line = br.readLine();
//            String[] q = line.trim().split("\\s+");
//            int n =Integer.parseInt(q[0]);
//            int m =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
    //        int k = Integer.parseInt(br.readLine());
//            String line2 = br.readLine();
//            String[] a2 = line2.trim().split("\\s+");
//            long b[] = new long[m];
//            for (int i = 0; i < m; i++) {
//                b[i] = Long.parseLong(a2[i]);
//            }
     //       int k = Integer.parseInt(br.readLine());
            Solution ob = new Solution();
            ArrayList<Long> ans=ob.arranged(a,n);
            for(int i=0;i<n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<Long> arranged(long a[], int n) {
         int i=0;//pointers to +ve elements
        int j=0;//pointers to -ve elements
        
        while(i<n && a[i]<0) i++;//i points to 1st positive elements
        while(j<n && a[j]>0) j++;//j points to 1st negative elements
        
        ArrayList<Long> l=new ArrayList<>();
        
        while(i<n || j<n)
        {
            l.add(a[i]);i++;
            //now move i to next +ve elemtns
            while(i<n && a[i]<0) i++;
            
            
            l.add(a[j]);j++;
            //now move j to next -ve elemtns
            while(j<n && a[j]>0) j++;
        }
        
        return l;
    }
}
