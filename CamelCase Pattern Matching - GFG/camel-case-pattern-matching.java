//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<String> CamelCase(int N,String[] Dictionary,String Pattern){
        Arrays.sort(Dictionary);
        //code here
        ArrayList<String> al = new ArrayList<>();
        int patLen = Pattern.length();
        int ptr = 0;
        for(String str : Dictionary) {
            String st = "";
            for(int i=0; i<str.length(); i++) {
                char ch = str.charAt(i);
                if(ch >= 'A' && ch <= 'Z') {
                    st += ch;
                }
                if(st.equals(Pattern)) {
                    al.add(str);
                    break;
                }
            }
        }
        if(al.isEmpty()) {
            al.add("-1");
        }
        return al;
    }
}