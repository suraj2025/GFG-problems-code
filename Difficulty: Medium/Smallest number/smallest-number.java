//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        // code here
        if(9*d<s) return "-1";
        if(d==1) return s+"";
        String sb="";
        s=s-1;
        for(int i=0;i<d-1;i++){
            if(s>=9) {
                sb=9+sb;
                s=s-9;
            }
            else {
                sb=s+sb;
                s=0;
            }
            
        }
        int a=s+1;
        return a+sb;
        
    }
}
