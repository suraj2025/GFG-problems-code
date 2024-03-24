//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = read.readLine().split(" ");

            Solution ob = new Solution();
            String[] res = ob.findPrefixes(arr,N);
            
            for(int i=0; i<res.length; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class TrieNode {
    char ch;
    Map<Character, TrieNode> children;
    int frequency;

    TrieNode(char ch) {
        this.ch = ch;
        children = new HashMap<>();
        frequency = 0;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode('\0');
    }

    void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode(ch));
            current = current.children.get(ch);
            current.frequency++;
        }
    }

    String getShortestUniquePrefix(String word) {
        StringBuilder prefix = new StringBuilder();
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            prefix.append(ch);
            current = current.children.get(ch);
            if (current.frequency == 1)
                return prefix.toString();
        }
        return ""; // Should not reach here
    }
}

class Solution {
    static String[] findPrefixes(String[] arr, int N) {
        Trie trie = new Trie();
        for (String word : arr) {
            trie.insert(word);
        }

        String[] prefixes = new String[N];
        for (int i = 0; i < N; i++) {
            prefixes[i] = trie.getShortestUniquePrefix(arr[i]);
        }
        return prefixes;
    }

    
    
}