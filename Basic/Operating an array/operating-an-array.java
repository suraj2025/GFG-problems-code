//{ Driver Code Starts
import java.util.*;
class Operating{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			List<Integer> a = new ArrayList<>();
			for(int i=0;i<n;i++){
				a.add(sc.nextInt());
			}
			int x = sc.nextInt();
			int y = sc.nextInt();
			int yi = sc.nextInt();
			int z = sc.nextInt();
			GfG g = new GfG();
			boolean b = g.searchEle(a,x);
			if(b==true)
				System.out.print("1 ");
			else
				System.out.print("0 ");
			b = g.insertEle(a,y,yi);
			if(b){
			if(a.get(yi)==y)
				System.out.print("1 ");
			else
				System.out.print("0 ");
			}
			else
				System.out.print("0 ");
			b = g.deleteEle(a,z);
			if(b){
			if(!g.searchEle(a,z))
				System.out.println("1 ");
			else
				System.out.println("0 ");
			}
			else
				System.out.println("0 ");
		}
	}
}
// } Driver Code Ends


/*Complete the function(s) below*/
class GfG
{		
	public boolean searchEle(List<Integer> a,int x)
       {
		//add code here.
		return a.indexOf(x)>=0; 
	}
	public boolean insertEle(List<Integer> a,int y,int yi)
        {
              //add code here.	
              a.set(yi,y);
              return true;
	}
	public boolean deleteEle(List<Integer> a,int z)
        {
		//add code here.
		a.remove(Integer.valueOf(z));
		return true;
		
	}
}