class Solution {
    static int MCM(int i,int j,int arr[]){
        if(i==j) return 0;
        int min=(int)1e9;
        for(int k=i;k<j;k++){
            int step=arr[i-1]*arr[k]*arr[j]+MCM(i,k,arr)+MCM(k+1,j,arr);
            min=Math.min(min,step);
        }
        return min;
    } 
    static int matrixMultiplication(int arr[]) {
        // code here
        int n=arr.length;
        int dp[][]=new int[n][n];
        for(int i=n-1;i>=1;i--){
            for(int j=i+1;j<n;j++){
                int min=(int)1e9;
                for(int k=i;k<j;k++){
                    int step=arr[i-1]*arr[k]*arr[j]+dp[i][k]+dp[k+1][j];
                    min=Math.min(min,step);
                }
                dp[i][j]= min;
            }
        }
        return dp[1][n-1];
        
    }
}