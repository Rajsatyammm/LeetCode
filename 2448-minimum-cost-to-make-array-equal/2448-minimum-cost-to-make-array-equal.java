class Solution {
    public long minCost(int[] nums, int[] cost) {
      int n=nums.length;
        long l=nums[0],h=nums[0];
        for(int i=1;i<n;i++){
          l=Math.min(nums[i],l);
          h=Math.max(nums[i],h);
        }
        long ans=Long.MAX_VALUE;
        while(l<=h){
          long mid=l+(h-l)/2;
          long arr[]=Findcost(mid,nums,cost);
          long left=arr[0];
          long midans=arr[1];
          ans=Math.min(ans,midans);
         
          if(left<midans){
            ans=Math.min(ans,left);
            h=mid-1;
          }
          else {
            l=mid+1;
          }
        }
        return ans;
    }
    long[] Findcost(long mid,int[] nums,int[] cost){
      long ans1=0;
      long ans2=0;
      long j=mid-1;
      for(int i=0;i<nums.length;i++){
        ans1+=Math.abs(nums[i]-mid)*cost[i];
        ans2+=Math.abs(nums[i]-j)*cost[i];
      }
      return new long[]{ans2,ans1};
    }
}