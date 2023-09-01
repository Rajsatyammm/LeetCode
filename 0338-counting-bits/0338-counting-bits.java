class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n+1];
        for(int num = 0; num <= n; num++)
            res[num] = (bitCount(num));
        return res;
    }

    int bitCount(int num) {
        int cnt = 0;
        while(num > 0){
            cnt++;
            num &= (num-1);
        }
        return cnt;
    }    
}