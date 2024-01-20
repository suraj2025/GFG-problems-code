//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        HashMap<Integer, Integer> countMap = new HashMap<>();

        // Count element occurrences
        
        ArrayList<Integer> l=new ArrayList<>();
        
        for (int num : arr) {

            countMap.put(num, countMap.getOrDefault(num, 0)+1 );
            
            
        }
        for (Map.Entry<Integer,Integer> entry :countMap.entrySet()){
            if(entry.getValue()>=2){
                l.add(entry.getKey());
            }
        }
        Collections.sort(l); 
        if(l.size()==0){
            l.add(-1);
            return l; 
        }
       return l;
    }
}
