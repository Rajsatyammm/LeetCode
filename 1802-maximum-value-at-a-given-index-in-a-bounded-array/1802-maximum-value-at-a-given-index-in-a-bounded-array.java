class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 0;
        int right = maxSum - n;

        while(left < right) {
            int mid = (left + right + 1) / 2;
            if(isRight(n, index, maxSum - n, mid)) 
                left = mid;
            else
                right = mid - 1;
        }
        return left + 1;
    }

    public boolean isRight(int n, int idx, int maxSum, int val) {
        int leftVal = Math.max(val - idx, 0);
        int rightVal = Math.max(val - ((n - 1) - idx), 0);

        long sumBefore = (long) (val + leftVal) * (val - leftVal + 1) / 2;
        long sumAfter = (long) (val + rightVal) * (val - rightVal + 1) / 2;

        return sumBefore + sumAfter - val <= maxSum;
    }


}