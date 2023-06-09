class Solution {
    // Approach 1 : 
    public char nextGreatestLetter(char[] letters, char target) {
        boolean[] arr = new boolean[26];
        for(int i=0; i<letters.length; i++) {
            int idx = letters[i] - 'a';
            arr[idx] = true;
        }
        int idx = target - 'a';
        while(true) {
            int id = (idx + 1) % 26;
            if(arr[id]) {
                char ch = (char)(id + 'a');
                return ch;
            }
            idx++;
        }
    }
    
    
    // Approach 2 : 
    // public char nextGreatestLetter(char[] letters, char target) {
    //     int start = 0, end = letters.length - 1;
    //     while(start <= end){
    //         int mid = (start + end)/2;
    //         if(target < letters[mid]) end = mid - 1;
    //         else start = mid + 1;
    //     }
    //     return start == letters.length ? letters[0] : letters[start];
    // }
}