//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    boolean DFS(int st,ArrayList<ArrayList<Integer>> adj,boolean vis[],boolean pathVis[]){
        vis[st]=true;
        pathVis[st]=true;
        for(int e:adj.get(st)){
            if(!vis[e]){
                if(DFS(e,adj,vis,pathVis)) return true;
            }
            else if(vis[e]&&pathVis[e]) return true;
        }
        pathVis[st]=false;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis[]=new boolean[V];
        boolean pathVis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(DFS(i,adj,vis,pathVis)){
                    return true;
                }
            }
        }
        return false;
    }
}