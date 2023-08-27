//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        sum(0, arr, al, new ArrayList<>());
        Collections.sort(al);
        return al;
    }
    
    void sum(int i, ArrayList<Integer> arr, ArrayList<Integer> ans, ArrayList<Integer> temp) {
        if(i == arr.size()) {
            int sum = 0;
            for(int n : temp)  {
                sum += n;
            }
            ans.add(sum);
            return;
        }
        //take
        temp.add(arr.get(i));
        sum(i+1, arr, ans, temp);
        temp.remove(temp.size()-1);
        
        //nottake
        sum(i+1, arr, ans, temp);
        
    }
}