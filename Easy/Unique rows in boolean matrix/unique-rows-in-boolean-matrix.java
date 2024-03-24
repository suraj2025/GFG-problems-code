//{ Driver Code Starts
import java.lang.Math;
import java.io.*;
import java.util.*;
class UniqueRows{
public static void main(String[] args)throws IOException
 {  
     BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
     PrintWriter out=new PrintWriter(System.out);
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    String s[]=in.readLine().trim().split(" ");
			int r=Integer.parseInt(s[0]);
			int c=Integer.parseInt(s[1]);
			s=in.readLine().trim().split(" ");
			int ind=0;
			int[][] a=new int [r][c];
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
					a[i][j]=Integer.parseInt(s[ind++]);
			GfG g=new GfG();
			ArrayList<ArrayList<Integer>> arr = g.uniqueRow(a,r,c);
			for(int i = 0;i<arr.size();i++){
			    ArrayList<Integer> demo = arr.get(i);
			    for(int j = 0;j<demo.size();j++){
			        out.print(demo.get(j)+" ");
			    }
			    out.print("$");
			}
			out.println();
		}
		out.close();
 }
}
// } Driver Code Ends


/*Complete the given function*/
class GfG{
    
    static class Trie{
        
        Trie child[]=new Trie[2];
        
    }
    
    static void insert(Trie head,int a[][],int r,int c,ArrayList<ArrayList<Integer>> res ){
        
        ArrayList<Integer> temp=new ArrayList<>();
        boolean flag=false;
        
        for(int i=0;i<c;i++){
            temp.add(a[r][i]);
            int index=a[r][i];
            if(head.child[index]==null){
                flag=true;
                head.child[index]=new Trie();
            }
            head=head.child[index];
        }
        
        if(flag==true){
            res.add(temp);
        }
        
    }
    
    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c){
        
        Trie head=new Trie();
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        
        for(int i=0;i<r;i++){
            insert(head,a,i,c,res);
        }
        
        return res;
        
    }
}