import java.util.*;
import java.lang.*;
import java.io.*;

class Pair<X, Y> {
    public final X first;
    public final Y second;

    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    public X getKey() {
        return first;
    }

    public Y getValue() {
        return second;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                arr[i] = a;
            }
            HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
            for (int i = 1; i <= n - 1; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (!adj.containsKey(a)) {
                    adj.put(a, new ArrayList<>());
                }
                if (!adj.containsKey(b)) {
                    adj.put(b, new ArrayList<>());
                }
                adj.get(a).add(b);
                adj.get(b).add(a);
            }
            int even = 0;
            int odd = 0;
            Queue<Pair<Integer, Integer>> q = new LinkedList<>();
            q.add(new Pair<>(1, 1));
            int[] vis = new int[n];
            while (!q.isEmpty()) {
                Pair<Integer, Integer> it = q.poll();
                if (it.getValue() == 1) {
                    odd += arr[it.getKey() - 1];
                } else {
                    even += arr[it.getKey() - 1];
                }
                vis[it.getKey() - 1] = 1;
                int flag = 1;
                if (it.getValue() == 1) {
                    flag = 2;
                }
                // Adding null check here
                ArrayList<Integer> neighbors = adj.get(it.getKey());
                if (neighbors != null) {
                    for (int j : neighbors) {
                        if (vis[j - 1] == 0) {
                            q.add(new Pair<>(j, flag));
                        }
                    }
                }
            }
            System.out.println(Math.abs(even - odd));
        }
    }
}
