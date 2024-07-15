//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    void DFS(int st,ArrayList<ArrayList<int[]>>adj,boolean[] vis,Stack<Integer> stack){
        vis[st]=true;
        for(int e[]:adj.get(st)){
            if(!vis[e[0]]){
                DFS(e[0],adj,vis,stack);
            }
        }
        stack.push(st);
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<int[]>>adj=new ArrayList<>();
		for(int i=0;i<N;i++){
		    adj.add(new ArrayList<>());
		}
		for(int e[]:edges){
		    adj.get(e[0]).add(new int[]{e[1],e[2]});
		}
		Stack<Integer> st=new Stack<>();
		boolean vis[]=new boolean[N];
		for(int i=0;i<N;i++){
		    if(!vis[i]){
		        DFS(i,adj,vis,st);
		    }
		}
		int[] dist = new int[N];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[0]=0;
        while(!st.isEmpty()){
            int u = st.pop();
            if (dist[u] != Integer.MAX_VALUE){
                for (int[] e : adj.get(u)) {
                    int v = e[0];
                    int weight = e[1];
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
                
            }
        }
         for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
		return dist;
		
	}
}

