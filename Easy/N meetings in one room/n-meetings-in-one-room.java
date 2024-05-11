//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int S[], int F[], int N)
    {
        // add your code here
        int ans[][] = new int[N][3]; 


       for( int i=0; i<N; i++){ 
           ans[i][0] =i+1; 
           ans[i][1] =S[i]; 
           ans[i][2] = F[i]; 
           
       }  
       Arrays.sort(ans,(a,b)-> Integer.compare(a[2],b[2])); 
       int res=1; 
       int et= ans[0][2]; 
       
       for(int i=1; i<N; i++){  
        
           if( ans[i][1]> et){ 
               res++; 
               et = ans[i][2];
           }
       }
        
        return res;
    }
}
