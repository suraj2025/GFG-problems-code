//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    void DFS(int node,ArrayList<ArrayList<Integer>>adjMatrix,boolean visited[]){
        visited[node] = true;
        for (int i = 0; i < adjMatrix.get(node).size(); i++) {
            if (adjMatrix.get(node).get(i) == 1 && !visited[i]) {
                DFS(i,adjMatrix, visited);
            }
        }
    }
    int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean vis[]=new boolean[V];
        int cnt=0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                cnt++;
                DFS(i,adj,vis);
            }
        }
        return cnt;
    }
};