//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends



/*
class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    
   public Node sort(Node head){
        //your code here, return the head of the sorted list
        Node tmp = head;
        Node h1 = new Node(-1); 
        Node h2 = h1;
        // h2=h1;
        
        while(tmp!=null && tmp.next!=null && tmp.next.next!=null  ){
            Node n = new Node(tmp.data);
            tmp=tmp.next.next;
            h1.next=n;
            h1=n;
        }
        if(tmp.next==null || tmp.next.next==null){
            Node n = new Node(tmp.data);
            h1.next=n;
            h1=n;
        }
        h1=fun(head.next, h1);
        h1.next=null;
        return h2.next;
    
   }
   public static Node fun(Node head, Node h1){
       if(head.next==null || head.next.next==null){
            Node n = new Node(head.data);
           h1.next=n;
           h1=n;
           return h1;
       }
       h1=fun(head.next.next, h1);
        Node n = new Node(head.data);
       h1.next=n;
       h1=n;
       return h1;
   }


}