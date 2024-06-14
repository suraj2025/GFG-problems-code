//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter ot = new PrintWriter(System.out);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.printUniqueSubsets(nums);
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override   public int compare(ArrayList<Integer> a,
                                             ArrayList<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            ot.print("[ ");
            for (int i = 0; i < ans.size(); i++) {
                ot.print("[ ");
                for (int j = 0; j < ans.get(i).size(); j++)
                    ot.print(ans.get(i).get(j) + " ");
                ot.print("]");
            }
            ot.println(" ]");
        }
        ot.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static void solve(int i, int[] arr, ArrayList<ArrayList<Integer>> res, List<Integer> ds) {
       
            res.add(new ArrayList<>(ds));
           

        for (int j = i; j < arr.length; j++) {
            if (j > i && arr[j] == arr[j - 1]) continue; // skip duplicates
             // no need to continue if the current element is greater than the target
            ds.add(arr[j]);
            solve(j + 1, arr, res, ds);
            ds.remove(ds.size() - 1); // backtrack
        }
    }
    public static ArrayList<ArrayList<Integer>> printUniqueSubsets(int[] nums) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        solve(0,nums,res,new ArrayList<>());
        return res;
    }
}