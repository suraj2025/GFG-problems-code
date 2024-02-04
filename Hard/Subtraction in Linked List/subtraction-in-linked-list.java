//{ Driver Code Starts
import java.util.Scanner;

// Node Class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Linked List Class
class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    // creates a new node with given value and appends it at the end of the linked list
    void insert(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
}


public class Main {
    static void printList(Node n) 
    {
        while (n != null) {
            System.out.print(n.data);
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            LinkedList LL1 = new LinkedList();
            String l1 = sc.next();
            for (int j = 0; j < n; ++j) {
                int x = Character.getNumericValue(l1.charAt(j));
                LL1.insert(x);
            }

            int m = sc.nextInt();
            LinkedList LL2 = new LinkedList();
            String l2 = sc.next();
            for (int j = 0; j < m; ++j) {
                int x = Character.getNumericValue(l2.charAt(j));
                LL2.insert(x);
            }

            Solution ob = new Solution();
            Node res = ob.subLinkedList(LL1.head, LL2.head);
            printList(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
      int length(Node n) {
        int ret = 0;
        while (n != null) {
            ret++;
            n = n.next;
        }
        return ret;
    }

    // method to reverse a linked list
    Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // storing next node
            current.next = prev; // linking current node to previous
            prev = current; // updating prev
            current = next; // updating current
        }

        return prev;
    }

    public Node subLinkedList(Node l1, Node l2) {
        // code here
        // long n1=0,n2=0;
        while (l1 != null && l1.data == 0) {
            l1 = l1.next;
            // removing trailing zeroes from l1
        }

        while (l2 != null && l2.data == 0) {
            l2 = l2.next;
            // removing trailing zeroes from l2
        }

        int n1 = length(l1);
        int n2 = length(l2);

        if (n1 == 0 && n2 == 0) {
            return new Node(0);
        }

        if (n2 > n1) {
            Node temp = l1;
            l1 = l2;
            l2 = temp;
            // making sure l1 list has the bigger number
        }

        if (n1 == n2) {
            Node t1 = l1;
            Node t2 = l2;
            while (t1.data == t2.data) {
                // finding which number is greater
                t1 = t1.next;
                t2 = t2.next;

                if (t1 == null) {
                    return new Node(0);
                    // returning zero if both numbers are the same
                }
            }

            if (t2.data > t1.data) {
                Node temp = l1;
                l1 = l2;
                l2 = temp;
                // making sure l1 list has the bigger number
            }
        }

        l1 = reverse(l1);
        l2 = reverse(l2);

        Node res = null;
        Node t1 = l1;
        Node t2 = l2;

        while (t1 != null) {
            int small = 0;
            if (t2 != null) {
                small = t2.data;
                // 'small' holds the next digit of the number to be subtracted
            }

            if (t1.data < small) {
                if (t1.next != null) {
                    t1.next.data -= 1;
                }
                t1.data += 10;
                // taking carry
            }

            Node n = new Node(t1.data - small);
            // creating a new node for storing the difference
            n.next = res;
            res = n;

            t1 = t1.next;
            if (t2 != null) {
                t2 = t2.next;
            }
        }

        while (res != null && res.next != null && res.data == 0) {
            res = res.next;
            // removing trailing zeroes from the result list
        }
        return res;
    }
}
        
