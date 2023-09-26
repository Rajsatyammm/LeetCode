//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required



// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        Arrays.sort(arr); 
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        if(n <= 3) 
            return ans;
        for(int i = 0;i<n-3;i++){
            if(i > 0 && arr[i] == arr[i-1]) 
                continue;
            for(int j = i+1; j < n-2;j++){
                if(j > i+1 && arr[j] == arr[j-1])
                    continue;
                int low = j+1;
                int high = n-1;
                
                while(low < high){
                    int sum = arr[low] + arr[high] + arr[i] + arr[j];
                    if(sum < k)
                        low++;
                    else if(sum > k)
                        high--;
                    else{
                        
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[low]);
                        temp.add(arr[high]);
                        ans.add(temp);
                       
                        while(low < high && arr[low] == arr[low + 1]) low++;
                        while(low < high && arr[high] == arr[high-1]) high--;
                        low++;
                        high--;
                    }
                }
            }
        }
        
        return ans;
    }
}