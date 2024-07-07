//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

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
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
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
    
    
    public  ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        HashMap<Node,Node> parent=new HashMap<>();
        
        Node t=markParent(root,parent,target);;
        Queue<Node> q=new LinkedList<>();
        HashSet<Node> set=new HashSet<>();
        q.offer(t);
        int dist=0;
        while(dist!=k){
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
        ArrayList<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().data);
        }
        // System.out.println(parent);
        Collections.sort(res);
        return res; 
    }
};