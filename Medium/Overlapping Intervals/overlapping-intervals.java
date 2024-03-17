//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] intervals)
    {
        // Code here // Code here
    Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
    ArrayList<int[]> list = new ArrayList<>();
    int i = 0;

    while (i < intervals.length) {
        int start = intervals[i][0];
        int end = intervals[i][1];
        while (i < intervals.length - 1 && intervals[i + 1][0] <= end) {
            end = Math.max(end, intervals[i + 1][1]);
            i++;
        }
        list.add(new int[]{start, end});
        i++;
    }

    int[][] result = new int[list.size()][2];
    for (int j = 0; j < list.size(); j++) {
        result[j] = list.get(j);
    }

    return result;
    }
}