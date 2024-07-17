//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);

            ot.println(list.get(0));
            if (list.get(0) != -1 && !check(list, edges)) ot.println(-1);
        }
        ot.close();
    }

    static boolean check(List<Integer> list, int edges[][]) {
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int i = 1; i < list.size(); i++) hs.add(list.get(i));
        for (int x[] : edges) {
            if (hs.contains(x[0]) || hs.contains(x[1])) {
                if (!hm.containsKey(x[0])) hm.put(x[0], new HashMap<>());
                if (!hm.containsKey(x[1])) hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (!hm.containsKey(list.get(i)) ||
                !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
}

// } Driver Code Ends


class Solution {
    class Pair {
        int distance, node;
        Pair(int d, int n) {
            distance = d;
            node = n;
        }
    }

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Initialize adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        // Populate adjacency list with edges
        for (int e[] : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        // Priority queue for Dijkstra's algorithm
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int dist[] = new int[n + 1];
        int parent[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        parent[1] = 1;
        pq.add(new Pair(0, 1));

        // Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int d = p.distance;
            int n1 = p.node;
            for (int e[] : adj.get(n1)) {
                int n2 = e[0];
                int w = e[1];
                if (d + w < dist[n2]) {
                    dist[n2] = d + w;
                    parent[n2] = n1;
                    pq.add(new Pair(dist[n2], n2));
                }
            }
        }

        // Check if the destination is reachable
        if (dist[n] == Integer.MAX_VALUE) {
            return Arrays.asList(-1);
        }

        // Reconstruct the path
        List<Integer> res = new ArrayList<>();
        int node = n;
        while (parent[node] != node) {
            res.add(node);
            node = parent[node];
        }
        res.add(1);
        Collections.reverse(res);

        // Add the weight of the path at the beginning
        res.add(0, dist[n]);

        return res;
    }

}