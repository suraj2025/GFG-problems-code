//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            int res = obj.countSubstring(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countSubstring(String s) {
        // code here
        int a=-1,b=-1,c=-1;
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a') a=i;
            if(s.charAt(i)=='b') b=i;
            if(s.charAt(i)=='c') c=i;
            if(a>=0&&b>=0&&c>=0){
                cnt+=Math.min(a,Math.min(b,c))+1;
            }
        }
        return cnt;
    }
}
        
