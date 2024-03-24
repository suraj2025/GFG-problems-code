//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            String[] keys = sc.nextLine().split(" ");

            TrieNode root = new TrieNode();
            for (int i = 0; i < n; i++) {
                insert(root, keys[i]);
            }
            String abc = sc.nextLine();
            if (search(root, abc))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
        }
    };

    
// } Driver Code Ends
// User function Template for Java

/*
static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) children[i] = null;
        }
    };
*/
//Function to insert string into TRIE.
static void insert(TrieNode node, String word) 
{
    // Your code here
    TrieNode root=node;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            int idx=ch-'a';
            if(root.children[idx]==null){
                root.children[idx]= new TrieNode();
            }
            if(i==word.length()-1){
                root.children[idx].isEndOfWord=true;
            }
            root=root.children[idx];
        }
}

//Function to use TRIE data structure and search the given string.
static boolean search(TrieNode node, String word)
{
    TrieNode root=node;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            int idx=ch-'a';
            if(root.children[idx]==null){
                return false;
            }
            if(i==word.length()-1&&!root.children[idx].isEndOfWord){
                return false;
            }
            root=root.children[idx];
        }
        return true;
}


//{ Driver Code Starts.
}
// } Driver Code Ends