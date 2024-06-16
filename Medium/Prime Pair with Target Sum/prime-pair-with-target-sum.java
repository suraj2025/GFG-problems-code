//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getPrimes(n);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends




class Solution {
    static boolean search(ArrayList<Integer> li,int k){
        int l=0,h=li.size()-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(li.get(mid)==k) return true;
            else if(li.get(mid)>k){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return false;
    }
    public static ArrayList<Integer> getPrimes(int n) {
        // code here
        int prime[]=new int[n+1];
        Arrays.fill(prime,1);
        for(int i=2;i*i<=n;i++){
            if(prime[i]==1){
                for(int j=i*i;j<=n;j+=i){
                    prime[j]=0;
                }
            }
        }
        ArrayList<Integer> p=new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(prime[i]==1){
                p.add(i);
            }
        }
        for(int i=0;i<p.size();i++){
            int k=n-p.get(i);
            if(k<0) continue;
            if(search(p,k)){
                return new ArrayList<Integer>(Arrays.asList(p.get(i), k));
            }
        }
        
        return  new ArrayList<Integer>(Arrays.asList(-1,-1));
    }
}
