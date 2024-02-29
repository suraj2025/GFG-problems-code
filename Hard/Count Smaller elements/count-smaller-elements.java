//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public int[] constructLowerArray(int[] nums, int n) {
        int[] count = new int[n];
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        mergeSort(nums, indexes, count, 0, n - 1);
        return count;
    }

    private void mergeSort(int[] nums, int[] indexes, int[] count, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, indexes, count, start, mid);
        mergeSort(nums, indexes, count, mid + 1, end);
        merge(nums, indexes, count, start, end);
    }

    private void merge(int[] nums, int[] indexes, int[] count, int start, int end) {
        int mid = start + (end - start) / 2;
        int left = start;
        int right = mid + 1;
        int rightCount = 0;
        int sortedIndex = 0;
        int[] newIndexes = new int[end - start + 1];

        while (left <= mid && right <= end) {
            if (nums[indexes[right]] < nums[indexes[left]]) {
                newIndexes[sortedIndex] = indexes[right];
                rightCount++;
                right++;
            } else {
                newIndexes[sortedIndex] = indexes[left];
                count[indexes[left]] += rightCount;
                left++;
            }
            sortedIndex++;
        }

        while (left <= mid) {
            newIndexes[sortedIndex++] = indexes[left];
            count[indexes[left]] += rightCount;
            left++;
        }

        while (right <= end) {
            newIndexes[sortedIndex++] = indexes[right++];
        }

        for (int i = start; i <= end; i++) {
            indexes[i] = newIndexes[i - start];
        }
    }
}

