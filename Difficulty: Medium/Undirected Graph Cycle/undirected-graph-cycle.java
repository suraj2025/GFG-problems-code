//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    boolean BFS(int V, ArrayList<ArrayList<Integer>> adj,int s,boolean []vis){
        Queue<int[]> q=new LinkedList<>();
        vis[s]=true;
        q.offer(new int[]{s,-1});
        while(!q.isEmpty()){
            int p[]=q.poll();
            for(int e:adj.get(p[0])){
                if(!vis[e]){
                    vis[e]=true;
                    q.offer(new int[]{e,p[0]});
                }
                else if(p[1]!=e ){
                    return true;
                }
            }
        }
       return false;
    }
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(BFS(V,adj,i,vis)){
                    return true;
                }
            }
        }
        return false;
    }
}