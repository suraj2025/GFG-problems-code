//{ Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}
// } Driver Code Ends


class Solution
{
    public static Node find(int[]in,int[]pre,int root,int left,int right){
        if(left > right || root > pre.length)return null;
        int mid = 0;
        for(int i = left ; i <= right ; i++){
            if(in[i] == pre[root]){
                mid = i;
                break;
            }
        }
        Node r = new Node(in[mid]);
        r.left = find(in,pre,root+1,left,mid-1);
        r.right = find(in,pre,root+mid-left+1,mid+1,right);
        return r;
    }
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here 
        return find(inorder,preorder,0,0,n-1);
    }
}

