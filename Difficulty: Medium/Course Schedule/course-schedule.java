//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);
            
            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int[] findOrder(int numCourses, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here
        if(numCourses==1) return new int[]{0};
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
       int inDegree[]=new int[numCourses];
        for(ArrayList<Integer> a:prerequisites){
            inDegree[a.get(0)]++;
            adj.get(a.get(1)).add(a.get(0));
        }
        int [] res=new int[numCourses];
        // for(ArrayList<Integer> a:adj){
        //     for(int e:a){
        //         inDegree[e]++;
        //     }
        // }
        Queue<Integer> q=new LinkedList<>();
        int j=0;
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }
        // if(q.isEmpty()) return new int[]{};
        while(!q.isEmpty()){
            int v=q.poll();
            res[j++]=v;
            for(int e:adj.get(v)){
                inDegree[e]--;
                if(inDegree[e]==0){
                    
                    q.offer(e);
                }
                
            }
        }
        if(j==numCourses)return res;
        return new int[]{};
    }
}