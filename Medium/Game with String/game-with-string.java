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
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(Map.Entry<Character,Integer> e: map.entrySet()){
            list.add(e.getValue());
        }
        int l=list.size();
        for(int i=0;i<k;i++){
            Collections.sort(list);
            list.set(l-1,list.get(l-1)-1);
        }
        int res=0;
        for(int num:list){
            res+=num*num;
        }
        return res;
    }
}