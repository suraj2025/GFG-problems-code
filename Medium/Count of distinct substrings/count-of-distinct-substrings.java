//{ Driver Code Starts
import java.util.*;

class suffix
{
     int index;  
    int rank[] = new int[2];
}

class UniqueSubStr
{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            GfG g = new GfG();
            System.out.println(g.countDistinctSubstring(st));
        }
    }
}
// } Driver Code Ends


/*You are required to complete this method */
class GfG
{
    static class Node{
        Node [] children;
        boolean eow;
        Node(){
            children=new Node[26];
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            eow=false;
        }
    }
    
   public static int countDistinctSubstring(String st)
   {
          if(st.length()==0){
           return 0;
       }
       int c=1;
      Node root=new Node();
      for(int i=0;i<st.length();i++){
          Node curr=root;
          for(int j=i;j<st.length();j++){
              int index =st.charAt(j)-'a';
              Node child=curr.children[index];
              if(child==null){
                  c++;
                 curr.children[index]=new Node();
                 
              }
              curr=curr.children[index];
          }
      }
      
      return  c;
      

   }
}