//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++) mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int[] a = IntArray.input(br, 2);

            int[][] mat = IntMatrix.input(br, a[0], a[1]);

            Solution obj = new Solution();
            int res = obj.findShortestPath(mat);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    static int length=0;
    static int flag=0;
    static int minLength=10000;
    public static int findShortestPath(int[][] mat) {
        // code here
        
        int i,j;
        int r=mat.length;
        int c=mat[0].length;
        boolean[][] vis=new boolean [r][c];
          for(i=0;i<r;i++){
            for(j=0;j<c;j++){
                vis[i][j]=false;
            }
            
        }
        j=0;
        length=0;
        minLength=Integer.MAX_VALUE;
        
        for(i=0;i<r;i++){
            length=1;
            flag=0;
            j=0;
            if((i-1)>=0 && mat[i-1][j]==0){
                continue;
            }
            if((i+1)<r && mat[i+1][j]==0){
                continue;
            }
            if((j+1)<c && mat[i][j+1]==0){
                continue;
            }
           
            for(int x=0;x<r;x++){
                for(int y=0;y<c;y++){
                    vis[x][y]=false;
                }
            }
            vis[0][0]=true;
           
            dfs(mat,i,j,r,c,vis);
            
        }
        
        if(flag==1){
            return minLength;
        }
        return -1;
    }
    
    static void dfs(int[][] mat,int i,int j,int r,int c,boolean[][] vis){
        
        if(j>c){
            return ;
        }
        
        if(i>r){
            return ;
        }
        
        if((i-1)>=0 && mat[i-1][j]==0){
                return ;
            }
        if((i+1)<r && mat[i+1][j]==0){
                return ;
            }
        if((j+1)<c && mat[i][j+1]==0){
              
                return ;
            }
         if((j-1)>=0 && mat[i][j-1]==0){
               
                return ;
            }
        
        
        if(j==c-1){
            
            if(length<=minLength){
                minLength=length;
            }
           
            flag=1;
        }
        
        if((j+1)<c && !vis[i][j+1] && (mat[i][j+1]==1)){
            j++;
            vis[i][j]=true;
            length++;
            
            dfs(mat,i,j,r,c,vis);
            length--;
            j--;
        } 
        if((i-1)>=0 && !vis[i-1][j] && (mat[i-1][j]==1)){
            i--;
            vis[i][j]=true;
            length++;
            dfs(mat,i,j,r,c,vis);
            length--;
            i++;
        }
        
        if((i+1)<r && !vis[i+1][j] && (mat[i+1][j]==1)){
            i++;
            vis[i][j]=true;
            length++;
            dfs(mat,i,j,r,c,vis);
            length--;
            i--;
        }
        
        {
            return ;
        }
    }
}
