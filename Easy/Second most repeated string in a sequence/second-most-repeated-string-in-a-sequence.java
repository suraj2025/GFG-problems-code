//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.secFrequent(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String secFrequent(String arr[], int N)
    {
        // your code here
            String s1="";
        int l=Integer.MIN_VALUE,l1=2;
        HashMap<String,Integer>hm=new HashMap<>();
        for(int i=0;i<N;i++){
            if(hm.containsKey(arr[i])){
                int h=hm.get(arr[i]);
                hm.put(arr[i],h+1);
            }
            else{
                hm.put(arr[i],1);
            }
        }
        while(l1-->0){
            s1="";
        for(Map.Entry<String,Integer>hr:hm.entrySet()){
           // s1="";
            if(hr.getValue()>l){
                l=hr.getValue();
                s1=hr.getKey();
            }
        }
        hm.remove(s1);
        l=Integer.MIN_VALUE;
        
        }
        return s1;
    }
}