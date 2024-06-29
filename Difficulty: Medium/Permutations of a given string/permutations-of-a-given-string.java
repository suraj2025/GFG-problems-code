//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    void swap(char []str,int i,int j){
        char temp=str[i];
        str[i]=str[j];
        str[j]=temp;
    }
    void permutation(char []str,ArrayList<String> res,int fi,int n){
        if(fi==n-1){
            if(!res.contains(new String(str))) 
            res.add(new String(str));
            return;
        }
        for(int i=fi;i<n;i++){
            swap(str,i,fi);
            permutation(str,res,fi+1,n);
            swap(str,i,fi);
        }
    }
    public List<String> find_permutation(String S) {
        // Code here
        ArrayList<String> res=new ArrayList<>();
        permutation(S.toCharArray(),res,0,S.length());
        Collections.sort(res);
        return res;
    }
}