//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

  public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache
{
    //Constructor for initializing the cache capacity with the given value.
    class Node{
        int key,value;
        Node next,prev;
        Node(int key,int value){
            this.key=key;
            this.value=value;
            next=prev=null;
        }
    }
    
    HashMap<Integer,Node> map=new HashMap<>();
    Node head,tail;
    int cap;
    LRUCache(int cap)
    {
        //code here
        this.cap=cap;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }
    
     void insert(Node n1){
        map.put(n1.key,n1);
        n1.next=head.next;
        head.next.prev=n1;
        head.next=n1;
        n1.prev=head;
       
        
    }
    
     void remove(Node n1){
        map.remove(n1.key);
        n1.prev.next=n1.next;
        n1.next.prev=n1.prev;
        
    }

    //Function to return value corresponding to the key.
    public  int get(int key)
    {
        // your code here
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        else return -1;
    }

    //Function for storing key-value pair.
    public  void set(int key, int value)
    {
        // your code here
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==cap){
            remove(tail.prev);
            
        }
        insert(new Node(key, value));
    }
}
