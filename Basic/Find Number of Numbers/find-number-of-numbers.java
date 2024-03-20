//{ Driver Code Starts
import java.util.*;
class Numbers{
public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
	while(t-->0)
	{
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i = 0; i < n; i++)
		{
			a[i]=sc.nextInt();
		}
		int k=sc.nextInt();
		GfG g=new GfG();
		System.out.println(g.num(a,n,k));
	}
}
}
// } Driver Code Ends


/*Complete the Function below*/
class GfG
{
          static int countK(int num,int k){
              int res=0;
              while(num>0)
                {
                    if(num%10==k)
                    {
                        res++;
                    }
                    num/=10;
                }
                return res;
          }
          public static int num(int a[], int n, int k)
            {
                 //Your code here
                   int cnt=0;
                for(int i=0;i<n;i++)
                {
                    int temp=a[i];
                    cnt+=countK(temp,k);
                    
                }
                return cnt;
            }
}