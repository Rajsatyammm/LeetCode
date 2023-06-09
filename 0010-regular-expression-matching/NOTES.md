<pre>
class Solution {
private boolean isReg(String s, String p) {
int N = s.length();
int M = p.length();
boolean[][] dp = new boolean[N+1][M+1];
// initialization
dp[0][0] = true;
for(int i=1; i<N; i++) dp[i][0] = false;
for(int j=1; j<=M; j++) {
if(p.charAt(j-1) == '*') dp[0][j] = dp[0][j-2];
else dp[0][j] = false;
}
​
// fill remaining
for(int i=1; i<=N; i++) {
for(int j=1; j<=M; j++) {
if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.')
dp[i][j] = dp[i-1][j-1];
else if(p.charAt(j-1) == '*') {
dp[i][j] = dp[i][j-2];
if (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') {
dp[i][j] = dp[i][j] || dp[i-1][j];
}
}