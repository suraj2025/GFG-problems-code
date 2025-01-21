//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            ArrayList<Integer> array2 = new ArrayList<Integer>();

            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            line = read.readLine();
            tokens = line.split(" ");
            for (String token : tokens) {
                array2.add(Integer.parseInt(token));
            }

            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr1 = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr1[idx++] = i;

            int[] arr2 = new int[array2.size()];
            idx = 0;
            for (int i : array2) arr2[idx++] = i;

            v = new Solution().intersection(arr1, arr2);

            if (v.size() > 0) {
                for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");
            } else {
                System.out.print("[]");
            }

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to return a list containing the intersection of two arrays.
    static ArrayList<Integer> intersection(int arr1[], int arr2[]) {
        // add your code here
        ArrayList<Integer> intersection=new ArrayList<Integer>();
        
        int i=0,j=0;
        while(i<arr1.length&&j<arr2.length){
            while(i+1<arr1.length&&arr1[i]==arr1[i+1]) i++;
            while(j+1<arr2.length&&arr2[j]==arr2[j+1]) j++;
            
            if(arr1[i]<arr2[j]) i++;
            else if(arr1[i]>arr2[j]) j++;
            else{
                intersection.add(arr1[i]);
                i++;
                j++;
            }
        }
        return intersection;
    }
}