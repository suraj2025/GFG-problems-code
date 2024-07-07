//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
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
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    Node markParent(Node root,HashMap<Node,Node> parent,int t){
        Queue<Node> q=new LinkedList<>();
        Node tar=new Node(-1);
        q.offer(root);
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr.data==t) tar=curr;
            if(curr.left!=null){
                q.offer(curr.left);
                parent.put(curr.left,curr);
            }
            if(curr.right!=null){
                q.offer(curr.right);
                parent.put(curr.right,curr);
            }
        }
        return tar;
    }
    
    
   
    
    public  int minTime(Node root, int target) 
    {
        // Your code goes here
        HashMap<Node,Node> parent=new HashMap<>();
        
        Node t=markParent(root,parent,target);;
        Queue<Node> q=new LinkedList<>();
        HashSet<Node> set=new HashSet<>();
        q.offer(t);
        int dist=0;
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Node node=q.poll();
                set.add(node);
                Node n1=parent.get(node);
                Node n2=node.left;
                Node n3=node.right;
                if(n1!=null&&!set.contains(n1)) q.offer(n1);
                if(n2!=null&&!set.contains(n2)) q.offer(n2);
                if(n3!=null&&!set.contains(n3)) q.offer(n3);
            }
            dist++;
        }
       return dist-1;
    }
}