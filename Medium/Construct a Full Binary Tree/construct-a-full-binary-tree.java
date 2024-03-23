//{ Driver Code Starts
//Initial Template for Java

import java.util.*;


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


class ConstructTree
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int pre[] = new int[n];
            int preM[] = new int[n];
            
            for(int i = 0; i < n; i++)
              pre[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preM[i] = sc.nextInt();
            
            GfG gfg = new GfG();  
           
            
            inorder(gfg.constructBTree(pre, preM, n));
            System.out.println();
            
        }
    }
    
    public static void inorder(Node root)
    {
        if(root == null)
         return;
         
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

// } Driver Code Ends


//User function Template for Java


class GfG
{
    static class INT{
       int a;
       INT(int a){
           this.a = a;
       }
   }
   public Node constructBTree(int pre[], int preM[], int size)
   {
       // your code here
       INT preIndex = new INT(0);
       return constructBTreeUtil(pre, preM, preIndex, 0, size - 1, size);
   }
   static Node constructBTreeUtil(int[] pre, int[] preM, INT preIndex, int l, int  h, int size){
       if(preIndex.a >= size || l>h)
           return null;
       Node root = new Node(pre[preIndex.a]);
       ++(preIndex.a);
       if(l == h)
           return root;
       int i;
       for(i=l; i<=h; i++)
           if(pre[preIndex.a] == preM[i])
               break;
       root.left = constructBTreeUtil(pre, preM, preIndex, i, h, size);
       root.right = constructBTreeUtil(pre, preM, preIndex, l+1, i-1, size);
       return root;
   }
    
}