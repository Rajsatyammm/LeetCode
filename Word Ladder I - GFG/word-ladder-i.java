//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution {
    
    class Pair {
        String s;
        int idx;
        
        Pair(String s, int i) {
            this.s = s;
            idx = i;
        }
    }
    
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        // Code here
        HashSet<String> set = new HashSet<>();
        for(String s : wordList) set.add(s);
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord, 1));
        
        int ans = 0;
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            String str = p.s;
            int currIdx = p.idx;
            
            for(int i=0; i<str.length(); i++) {
                for(char ch='a'; ch<='z'; ch++) {
                    String newStr = str.substring(0, i) + ch + str.substring(i+1);
                    if(set.contains(newStr)) {
                        q.add(new Pair(newStr, currIdx + 1));
                        set.remove(newStr);
                        
                        if(newStr.equals(targetWord)) {
                            ans = currIdx + 1;
                            break;
                        }
                    }
                }
            }
        }
        
        return ans;
    }
}