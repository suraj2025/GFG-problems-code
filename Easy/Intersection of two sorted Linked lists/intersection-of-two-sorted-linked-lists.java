//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}
class GfG
{
    static Scanner sc = new Scanner(System.in);
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
        {
            
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n , m;
                    
                    n = sc.nextInt();
                    m = sc.nextInt();
                    
                    Node head1 = inputList(n);
                    Node head2 = inputList(m);
                    
                    Solution obj = new Solution();
                    
                    Node result = obj.findIntersection(head1, head2);
	    
	                printList(result);
	                System.out.println();
                }
        }
}
// } Driver Code Ends


/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/

class Solution
{
    public static ArrayList<Integer> findIntersection(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        ArrayList<Integer> intersection = new ArrayList<>();
        for (Integer num : list1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        for (Integer num : list2) {
            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
                intersection.add(num);
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            }
        }

        return intersection;
    }
    
   public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        ArrayList<Integer> s1=new ArrayList<>();
        ArrayList<Integer> s2=new ArrayList<>();
        
        Node temp=head1;
        while(temp!=null){
            s1.add(temp.data);
            temp=temp.next;
        }
        temp=head2;
        while(temp!=null){
            s2.add(temp.data);
            temp=temp.next;
        }
        ArrayList<Integer> intersection = findIntersection(s1, s2);
        
        temp=new Node(-1);
        Node temp1=temp;
        for(int num:intersection){
            Node n1=new Node(num);
            temp1.next=n1;
            temp1=n1;
        }
       
        return temp.next;
    }
}