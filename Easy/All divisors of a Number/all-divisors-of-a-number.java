//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            obj.print_divisors(n);
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static void print_divisors(int n) {
        // Create two lists to store divisors
        ArrayList<Integer> smallDivisors = new ArrayList<>();
        ArrayList<Integer> largeDivisors = new ArrayList<>();
        
        // Iterate from 1 to sqrt(n)
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                smallDivisors.add(i);  // i is a divisor
                if (i != n / i) {
                    largeDivisors.add(n / i);  // n / i is a divisor and different from i
                }
            }
        }
        
        // Print small divisors
        for (int divisor : smallDivisors) {
            System.out.print(divisor + " ");
        }
        
        // Print large divisors in reverse order
        for (int i = largeDivisors.size() - 1; i >= 0; i--) {
            System.out.print(largeDivisors.get(i) + " ");
        }
    }
}

