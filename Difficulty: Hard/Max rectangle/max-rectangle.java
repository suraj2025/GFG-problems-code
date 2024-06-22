//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public static int getMaxArea(int[] heights, int N) {
        Stack<Integer> st = new Stack<>();
        int ans=0;
        
        // Calculate left array
        for (int i = 0; i <=N; i++) {
            
            while (!st.isEmpty()&&(i==N||heights[st.peek()]>heights[i])) {
                int h=heights[st.pop()];
                int w=0;
                if(st.isEmpty()){
                    w=i;
                }
                else{
                    w=i-st.peek()-1;
                    
                }
                ans=Math.max(ans,h*w);
            }
            st.push(i);
            
        }
        return ans;
    }
    public int maxArea(int M[][], int n, int m) {
        // add code here.
        int ans=getMaxArea(M[0],m);
        int prev[]=M[0].clone();
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(M[i][j]==1){
                    prev[j]=prev[j]+1;
                }
                else{
                    prev[j]=0;
                }
                
            }
            ans=Math.max(ans,getMaxArea(prev,m));
        }
        return ans;
    
    }
}