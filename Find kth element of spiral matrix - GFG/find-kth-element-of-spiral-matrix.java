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
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
        int Srow = 0, Scol = 0, Erow = n-1, Ecol = m-1, count = 0;
	    // Your code here
	    while(Srow <= Erow && Scol <= Ecol) {
    	    for(int j=Scol; j<=Ecol; j++) {
    	        count++;
    	        if(count == k)
    	            return A[Srow][j];
    	    }
    	    Srow++;
    	    
    	    for(int i=Srow; i<=Erow; i++) {
    	        count++;
    	        if(count == k) 
    	            return A[i][Ecol];
    	    }
    	    Ecol--;
    	    
    	    if(Srow <= Erow) {
        	    for(int j=Ecol; j>=Scol; j--) {
        	        count++;
        	        if(count == k)
        	            return A[Erow][j];
        	    }
        	    Erow--;
    	    }
    	    
    	    if(Scol <= Ecol) { 
        	    for(int i=Erow; i>=Srow; i--) {
        	        count++;
        	        if(count == k)
        	            return A[i][Scol];
        	    }
        	    Scol++; 
    	    }
	    }
	    return 0;
    }
    
}