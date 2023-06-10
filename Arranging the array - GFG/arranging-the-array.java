//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.Rearrange(a, n);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
                output.append(a[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    static class Info implements Comparable<Info> {
        int data;
        String val;
        int no;
        
        Info(int d, String s, int n) {
            data = d;
            val = s;
            no = n;
        }
        
        public int compareTo(Info i) {
            if(this.val.equals(i.val)) {
                return this.no - i.no;
            }
            else {
                return this.val.compareTo(i.val);
            }
        }
    }
    
    public void Rearrange(int a[], int n)
    {
        // Your code goes here
        int negIdx = 0;
        int posIdx = 0;
        PriorityQueue<Info> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            int value = a[i];
            if(value < 0) {
                negIdx++;
                pq.add(new Info(value, "N", negIdx));
            }
            else {
                posIdx++;
                pq.add(new Info(value, "P", posIdx));
            }
        }
        for(int i=0; i<n; i++) {
            a[i] = pq.remove().data;
        }
    }
}