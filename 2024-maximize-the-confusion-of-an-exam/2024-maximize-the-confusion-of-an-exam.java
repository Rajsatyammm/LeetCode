class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxLen = 1;
        int N = answerKey.length();
        int minChar = 0;
        int j = 0;
        int[] cnt = new int[2];
        for(int i=0; i<N; i++) {
            char ch = answerKey.charAt(i);
            if(ch == 'T') {
                cnt[0]++;
            } else {
                cnt[1]++;
            }
            minChar = Math.min(cnt[0], cnt[1]);
            if(minChar > k) {
                while(minChar > k) {
                    char ch1 = answerKey.charAt(j);
                    if(ch1 == 'T') cnt[0]--;
                    else cnt[1]--;
                    j++;
                    minChar = Math.min(cnt[0], cnt[1]);
                }
            }
            maxLen = Math.max(maxLen, i-j+1);
        }
        return maxLen;
    }
}