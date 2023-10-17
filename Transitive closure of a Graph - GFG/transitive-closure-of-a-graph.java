//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][]) {
        // code here
        int count=0;
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if(graph[i][j]==0)count++;
                arr.add(j, graph[i][j]);

            }
            arrayLists.add(i, arr);
        }
        if(count==(N*N)){
            for (int i = 0; i < N; i++) {
                ArrayList<Integer> arr = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    if(i==j)arr.add(j,1);
                    else
                        arr.add(j,graph[i][j]);
                }
                arrayLists.add(i, arr);
            }
        }else

        for (int k = 0; k <N; k++) {
            for (int i = 0; i <N; i++) {
                for (int j = 0; j <N; j++) {
                    
                    if (arrayLists.get(i).get(j) != 0 || (arrayLists.get(i).get(k)!=0 && arrayLists.get(k).get(j) != 0)) {
                        arrayLists.get(i).set(j,1);

                    }else if(i==j)
                        arrayLists.get(i).set(j,1);

                    else
                        arrayLists.get(i).set(j,0);
                
                }
            }
        }
        return arrayLists;

    }
}