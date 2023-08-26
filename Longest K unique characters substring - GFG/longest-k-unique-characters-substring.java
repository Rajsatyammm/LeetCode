//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
     
    public int longestkSubstr(String S, int k) {
         Map<Character, Integer> map = new HashMap<>();
 
        int i = -1;
        int j = -1;
        int ans = -1;
 
        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;
            while (i < S.length() - 1) {
                flag1 = true;
                i++;
                char ch = S.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
 
                if (map.size() < k)
                    continue;
                else if (map.size() == k) {
                    int len = i - j;
                    ans = Math.max(len, ans);
                }
                else
                    break;
            }
            while (j < i) {
                flag2 = true;
                j++;
                char ch = S.charAt(j);
 
                if (map.get(ch) == 1)
                    map.remove(ch);
                else
                    map.put(ch, map.get(ch) - 1);
 
                if (map.size() == k) {
                    int len = i - j;
                    ans = Math.max(ans, len);
                    break;
                }
                else if (map.size() > k)
                    continue;
            }
            if (flag1 == false && flag2 == false)
                break;
        }
        return ans;
    }
}