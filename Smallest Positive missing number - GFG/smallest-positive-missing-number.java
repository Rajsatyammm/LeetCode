//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size) {
        // Your code here
        int minPos = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr) {
            if(i > 0) 
                minPos = Math.min(minPos, i);
            map.put(i, 1);
        }
        
        // if(minPos == 0) {
        //     if(!map.containsKey(0)) {
        //         return 0;
        //     }
        //     else {
        //         return 1;
        //     }
        // }
        
        while(true) {
            if(!map.containsKey(minPos + 1)) {
                return minPos + 1;
            }
            minPos++;
        }
        // return 0;
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) 
    {

		Scanner sc=new Scanner(System.in);
		
        //taking testcases
		int t=sc.nextInt();
		while(t-->0){
		    
		    //input number n
			int n=sc.nextInt();
			int[] arr=new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=sc.nextInt();
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			System.out.println(missing);
		}
    }
}


// } Driver Code Ends