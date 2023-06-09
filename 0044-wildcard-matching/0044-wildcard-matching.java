class Solution {
    public boolean isMatch(String s, String p) {
        int sIndex = 0, pIndex = 0, matchIndex = 0, starIndex = -1;
        
        while (sIndex < s.length()) {
            if (pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '?')) {
                sIndex++;
                pIndex++;
            } else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                starIndex = pIndex;
                matchIndex = sIndex;
                pIndex++;
            } else if (starIndex != -1) {
                pIndex = starIndex + 1;
                matchIndex++;
                sIndex = matchIndex;
            } else {
                return false;
            }
        }
        
        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex++;
        }
        
        return pIndex == p.length();
    }
}

// class Solution {
//     public boolean isMatching(String s, String p) {
//         int N = s.length();
//         int M = p.length();
//         boolean[][] dp = new boolean[N+1][M+1];
//         //initialization
//         dp[0][0] = true;
//         for(int i=1; i<=N; i++) dp[i][0] = false;
//         for(int j=1; j<=M; j++) {
//             if(p.charAt(j-1) == '*') dp[0][j] = dp[0][j-1];
//             else dp[0][j] = false;
//         }

//         // fill the array dp
//         for(int i=1; i<=N; i++) {
//             for(int j=1; j<=M; j++) {
//                 if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?') 
//                     dp[i][j] = dp[i-1][j-1];
//                 else if(p.charAt(j-1) == '*')
//                     dp[i][j] = dp[i-1][j] || dp[i][j-1];
//                 else dp[i][j] = false;
//             }
//         }
//         return dp[N][M];
//     }
//     public boolean isMatch(String s, String p) {
//         return isMatching(s, p);
//     }
// }