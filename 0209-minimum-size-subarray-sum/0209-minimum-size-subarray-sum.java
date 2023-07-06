class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0,res=Integer.MAX_VALUE,s=0;
        for(r=0;r<nums.length;r++){
              s+=nums[r];
              while(s>=target){
                  s-=nums[l];
                  res = Math.min(res,r-l+1);
                  l++;
              }
        }
        if(res==Integer.MAX_VALUE)
        return 0;
        return res;
    }
}