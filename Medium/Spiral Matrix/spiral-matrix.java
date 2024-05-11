//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			Solution obj = new Solution();
			System.out.println(obj.findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
   
	public int findK(int matrix[][], int r, int c, int k)
	{
	    // Your code goes here
	   int res=-1;
        int left=0,top=0;
        int right=c-1;
        int bottom=r-1;
        int count=0;
        k=k-1;
        while(left<=right&&top<=bottom){
            for(int i=left;i<=right;i++){
                if(count==k){
                    return matrix[top][i];
                    
                }
                count++;
                
            }
            top++;
            for(int i=top;i<=bottom;i++){
                if(count==k){
                    return matrix[i][right];
                }
                 count++;
                
            }
            right--;
            if(top<=bottom){
            for(int i=right;i>=left;i--){
                if(count==k){
                   return  matrix[bottom][i];
                }
                count++;
                
                
            }
            bottom--;}
            if(left<=right){
                
            for(int i=bottom;i>=top;i--){
                if(count==k){
                    return matrix[i][left];
                }
                count++;
                
                
            }
            left++;}
        }
        return -1;
	}
	
}