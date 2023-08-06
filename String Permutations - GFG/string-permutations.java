//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    static ArrayList<String> al = new ArrayList<>();
    public ArrayList<String> permutation(String S) {
        //Your code here
        al.clear();
        perm(S, "");
        Collections.sort(al);
        return al;
    }
    
    static boolean perm(String str, String ans) {
        if(str.length()==0)  return al.add(ans);
        for(int i=0;i<str.length();i++) perm(str.substring(0,i) + str.substring(i+1), ans + str.charAt(i)); 
        return true;
    }
	   
}
