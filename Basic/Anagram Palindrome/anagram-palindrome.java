//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
    {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
		    String s = in.next();
		    if (new Sol().isPossible (s) == 1)
		        System.out.println ("Yes");
		    else
		        System.out.println ("No");
		}
	}
}

// Contributed By: Pranay Bansal


// } Driver Code Ends


class Sol
{
    int isPossible (String S)
    {
        // your code here
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:S.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int c=0;
        for(Map.Entry<Character,Integer> e:map.entrySet()){
            if(e.getValue()%2!=0){
                c++;
            }
        }
        if(S.length()%2==0&&c==0){
            return 1;
        }
        else if(S.length()%2!=0&&c==1){
            return 1;
        }
        return 0;
    }
}