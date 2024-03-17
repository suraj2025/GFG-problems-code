//{ Driver Code Starts
import java.util.Scanner;
import java.lang.Math;

class Convert_To_Five {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            System.out.println(new GfG().convertfive(N));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    int convertfive(int num) {
        // Your code here
        int res=0;
        
        while(num!=0){
            if(num%10==0){
                res=res*10+5;
            }
            else{
                res=res*10+num%10;
            }
            num/=10;
        }
        int r=0;
        while(res!=0){
            r=r*10+res%10;
            res/=10;
        }
        return r;
    }
}