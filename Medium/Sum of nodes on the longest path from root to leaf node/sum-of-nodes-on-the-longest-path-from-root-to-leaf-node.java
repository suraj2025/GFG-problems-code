//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 


class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}

class GFG {
    
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void inorder(Node root){
        if(root == null)
            return;
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
		while(t-- > 0){
		    String s = br.readLine();
	    	Node root = buildTree(s);
		    Solution obj = new Solution();
		    int res = obj.sumOfLongRootToLeafPath(root);
		    System.out.println(res);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

/*
node class of binary tree
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
//Back-end complete function Template for Java

class Solution{
   class Res
    {
        int maxSum = Integer.MIN_VALUE; // create a variable to store the maximum sum, initialize it to the smallest possible value
        int maxLen = 0; // create a variable to store the maximum length, initialize it to 0
    }
    
    public int sumOfLongRootToLeafPath(Node root)
    {
        Res r = new Res(); // create an object of the Res class to store the result
        Res s = new Res(); // create an object of the Res class to store intermediate result
        if(root == null)
          return 0; // if root is null, return 0 as there are no nodes
        
        sumOfLongRootToLeafPathUtil(root, 0, 0, s, r); // call the helper function to calculate the maximum sum of the long root to leaf path
        return r.maxSum; // return the maximum sum
    }
    
    public void sumOfLongRootToLeafPathUtil(Node root, int sum, int len, Res s, Res r)
    {
        if(root == null) // if current node is null, check if current length is greater than the maximum length obtained so far
        {
        if (s.maxLen < len) 
        {
            s.maxLen = len; // update the maximum length
            r.maxSum = sum; // update the maximum sum
        }
        else if (s.maxLen == len && r.maxSum < sum)
            r.maxSum = sum; // update the maximum sum if current length is equal to the maximum length obtained so far and current sum is greater
            
            return; // return as we have reached the leaf node
        }
        
        sumOfLongRootToLeafPathUtil(root.left, sum + root.data, len + 1, s, r); // recursively call the function for the left child with updated sum and length
        sumOfLongRootToLeafPathUtil(root.right, sum + root.data, len + 1,s, r); // recursively call the function for the right child with updated sum and length
    }
}
