//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.math.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //taking number of elements
		    int n=sc.nextInt();
		   
		    //calling findCatalan() method
		    System.out.println(new Solution().findCatalan(n));
		}
	}
}
// } Driver Code Ends



class Solution
{
    //Function to find the nth catalan number.
    public static BigInteger findCatalan(int n)
    {
        //Your code here
        BigInteger b = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            b = b.multiply(BigInteger.valueOf(i));
        }
        b = b.multiply(b);
 
        BigInteger d = new BigInteger("1");
        for (int i = 1; i <= 2 * n; i++) {
            d = d.multiply(BigInteger.valueOf(i));
        }
        BigInteger ans = d.divide(b);
 
        ans = ans.divide(BigInteger.valueOf(n + 1));
        return ans;
    }
}