//{ Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
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
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static class Tuple {
        Node node;
        int verticle, level;

        Tuple(Node node, int v, int l) {
            this.node = node;
            this.verticle = v;
            this.level = l;
        }
    }

    // Function to find the vertical order traversal of Binary Tree.
    static ArrayList<Integer> verticalOrder(Node root) {
        // Map to store nodes based on vertical and level positions
         TreeMap<Integer, TreeMap<Integer, List<Integer>>> nodes = new TreeMap<>();

        // Queue for BFS traversal, each element is a tuple containing node and its vertical and level information
        Queue<Tuple> todo = new LinkedList<>();

        // Push the root node with initial vertical and level values (0, 0)
        todo.add(new Tuple(root, 0, 0));

        // BFS traversal
        while (!todo.isEmpty()) {
            // Retrieve the node and its vertical and level information from the front of the queue
            Tuple t = todo.poll();
            Node temp = t.node;

            // Extract the vertical and level information
            int x = t.verticle;
            int y = t.level;

            // Initialize the map for 'x' if it doesn't exist
            nodes.putIfAbsent(x, new TreeMap<>());

            // Initialize the list for 'y' if it doesn't exist
            nodes.get(x).putIfAbsent(y, new ArrayList<>());

            // Add the data value to the list
            nodes.get(x).get(y).add(temp.data);

            // Process left child
            if (temp.left != null) {
                todo.add(new Tuple(temp.left, x - 1, y + 1));
            }

            // Process right child
            if (temp.right != null) {
                todo.add(new Tuple(temp.right, x + 1, y + 1));
            }
        }

        // Prepare the final result list by combining values from the map
        ArrayList<Integer> ans = new ArrayList<>();

        for (Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : nodes.entrySet()) {
            for (Map.Entry<Integer, List<Integer>> levels : entry.getValue().entrySet()) {
                ans.addAll(levels.getValue());
            }
        }

        return ans;
    }
}