import java.util.Arrays;

public class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26]; 
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int del = 0;
        for (int i = 24; i >= 0; i--) {
            // No more characters with this frequency
            if (freq[i] == 0) {
                break; 
            }
            
            // Update the deletion count
            if (freq[i] >= freq[i + 1]) {
                int prev = freq[i];
                freq[i] = Math.max(0, freq[i + 1] - 1);
                del += prev - freq[i]; 
            }
        }
        
        return del;
    }
}