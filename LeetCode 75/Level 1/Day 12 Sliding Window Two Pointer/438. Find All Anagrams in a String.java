// 438. Find All Anagrams in a String

class Solution {
    //compare function to compare the frequency of both the string character
    private boolean compare(int[] Parr, int[] Sarr) {
        for(int i=0; i<Parr.length; i++) {
            if(Parr[i] != Sarr[i]) {
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        
        int[] Parr = new int[26];
        int[] Sarr = new int[26];
        List<Integer> al = new ArrayList<>();

        // if length of p is greater than s then return empty list
        if(p.length() > s.length()) return al;

        // storing the frequency of character of String P
        for(int i=0; i<p.length(); i++) {
            char ch = p.charAt(i);
            Parr[ch - 'a']++;
        }

        int k = p.length();
        
        // Sliding window of size of length of string p
        for(int i=0; i<p.length(); i++) {
            char ch = s.charAt(i);
            Sarr[ch - 'a']++;
        }

        //iterate till k is not at the last of string s
        while(k < s.length()) {
            // if frequency of character matches then add to list
            if(compare(Parr, Sarr)) {
                //adding the first index to list
                al.add(k - p.length());
            }

            char chToAdd = s.charAt(k);
            //increrase the frequency of the particular character
            Sarr[chToAdd - 'a']++;

            char chToRemove = s.charAt(k - p.length());
            //decrease the frequency of the particular character
            Sarr[chToRemove - 'a']--;
            k++;
        }
        if(compare(Parr, Sarr)) {
            al.add(k - p.length());
        }

    return al;
    }
}
