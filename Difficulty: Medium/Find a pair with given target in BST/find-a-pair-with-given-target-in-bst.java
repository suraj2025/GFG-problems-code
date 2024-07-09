//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            int target = Integer.parseInt(br.readLine().trim());
            
            Solution T = new Solution();
            System.out.println(T.isPairPresent(root,target));
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class BSTIterator {
    private Stack<Node> st=new Stack<>();
    boolean reverse=false;
    public BSTIterator(Node root ,boolean rev) {
        reverse=rev;
        pushAll(root);
    }
    void pushAll(Node root){
        while(root!=null){
            st.push(root);
            if(reverse){
                root=root.right;
            }
            else
            root=root.left;
        }
    }
    public int next() {
        Node node=st.pop();
        if(reverse){

        pushAll(node.left);
        }
        else
        pushAll(node.right);
        return node.data;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}
class Solution {
     public int isPairPresent(Node root, int k) {
        BSTIterator i1=new BSTIterator(root,false);
        BSTIterator i2=new BSTIterator(root,true);
        int left = i1.next();
        int right = i2.next();
        
        while (left < right) {
            if (left + right == k) {
                return 1;
            } else if (left + right < k) {
                if (i1.hasNext()) {
                    left = i1.next();
                } else {
                    break;
                }
            } else {
                if (i2.hasNext()) {
                    right = i2.next();
                } else {
                    break;
                }
            }
        }

        return 0;
    }
}
 
