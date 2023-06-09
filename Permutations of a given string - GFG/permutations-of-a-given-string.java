//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    
    public List<String> find_permutation(String S) {
        // Code here
        List<String> permutations = new ArrayList<>();
        permute(S.toCharArray(), 0, permutations);
        Collections.sort(permutations);
        return permutations;
    }

    private static void permute(char[] chars, int currentIndex, List<String> permutations) {
        if (currentIndex == chars.length - 1) {
            permutations.add(String.valueOf(chars));
            return;
        }

        for (int i = currentIndex; i < chars.length; i++) {
            if (shouldSwap(chars, currentIndex, i)) {
                swap(chars, currentIndex, i);
                permute(chars, currentIndex + 1, permutations);
                swap(chars, currentIndex, i); // backtrack
            }
        }
    }

    private static boolean shouldSwap(char[] chars, int start, int end) {
        for (int i = start; i < end; i++) {
            if (chars[i] == chars[end])
                return false;
        }
        return true;
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}