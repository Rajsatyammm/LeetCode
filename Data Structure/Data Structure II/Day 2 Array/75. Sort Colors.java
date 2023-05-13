// 75. Sort Colors

class Solution {
    public void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for(int i=0; i<nums.length; i++) {
            //zerocount
            if(nums[i] % 2 == 0) {
                if(nums[i] == 0) zeroCount++;
                //two count
                else twoCount++;
            }
            //one count
            else oneCount++;
        }

        for(int i = 0; i < zeroCount; i++) nums[i] = 0;
        for(int i = zeroCount; i < zeroCount + oneCount; i++) {nums[i] = 1;}
        for(int i = zeroCount + oneCount; i < (zeroCount + oneCount + twoCount); i++) nums[i] = 2;

    }
}
