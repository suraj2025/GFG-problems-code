//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        HashMap<String,Integer> map=new HashMap<>();
        for(String s:arr){
            map.put(s,map.getOrDefault(s,0)+1);
        }
     
        String name="";
        int vote=0;
        for (Map.Entry<String,Integer> e : map.entrySet()){
            if(e.getValue()>vote){
                vote=e.getValue();
                name=e.getKey();
            }
            else if(e.getValue()==vote){
                if((name.compareTo(e.getKey()))>0){
                    name=e.getKey();
                }
            }
        }
        
        return new String[]{name,""+vote};
    }
}

