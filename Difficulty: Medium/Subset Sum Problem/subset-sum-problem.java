//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{

    // static Boolean helper(int idx,int k,int arr[],int dp[][]){
    //     if(k==0) return true;
    //     if(idx==0) return arr[idx]==k;
    //     if(dp[idx][k]!=-1) return dp[idx][k]==1;
    //     boolean notPick=helper(idx-1,k,arr,dp);
    //     boolean pick=false;
    //     if(k>=arr[idx]){
    //         pick=helper(idx-1,k-arr[idx],arr,dp);
    //     }
    //     dp[idx][k]=(pick||notPick)?1:0;
    //     return pick||notPick;
        
    // }
    // static Boolean isSubsetSum(int N, int arr[], int sum){
    //     // code here
    //     int dp[][]=new int[N][sum+1];
    //     for(int i=0;i<N;i++){
    //         Arrays.fill(dp[i],-1);
    //     }
    //     return helper(N-1,sum,arr,dp);
    // }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        boolean dp[][]=new boolean[N][sum+1];
        for(int i=0;i<N;i++){
            dp[i][0]=true;
        }
         if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }
        
        for(int i=1;i<N;i++){
            for(int k=1;k<=sum;k++){
                boolean notPick=dp[i-1][k];
                boolean pick=false;
                if(k>=arr[i]){
                    pick=dp[i-1][k-arr[i]];
                }
                dp[i][k]=pick||notPick;
            }
        }
        return dp[N-1][sum];
    }
}