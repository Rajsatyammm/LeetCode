class Solution {

    public int[] sortEvenOdd(int[] nums) {
        int N = nums.length;
        int[] evenIdx = (N % 2 == 0) ? new int[N/2] : new int[N/2 + 1];
        int[] oddIdx = new int[N/2];
        int eIdx = 0, oIdx = 0;
        for(int i=0; i<N; i++) {
            if(i % 2 == 0)  {
                evenIdx[eIdx] = nums[i];
                eIdx++;
            }
            else {
                oddIdx[oIdx] = nums[i];
                oIdx++;
            }
        }
        Arrays.sort(evenIdx);
        Arrays.sort(oddIdx);

        int[] res = new int[N];
        eIdx = 0;
        oIdx = oddIdx.length - 1;

        for(int i=0; i<N; i++) {
            if(i % 2 == 0) {
                res[i] = evenIdx[eIdx];
                eIdx++;
            }
            else {
                res[i] = oddIdx[oIdx];
                oIdx--;
            }
        }

        return res;
    }
}