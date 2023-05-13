// 136. Single Number

class Solution {
    public int singleNumber(int[] nums) {
        // Approach : 1
        // int idx = -1;
        // for(int i=0; i<nums.length; i++) {
        //     int count = 0;
        //     for(int j=0; j<nums.length; j++) {
        //         if(nums[i] == nums[j]) {
        //             count++;
        //         }
        //     }
        //     if(count == 1) {
        //         idx = i;
        //         break;
        //     }
        // }
        // return nums[idx];
        

        // Approach : 2
        // Arrays.sort(nums);
        // if(nums.length == 1) {
        //     return nums[0];
        // }

        // for(int i=0; i<nums.length-1; i+=2) {
        //     if(nums[i] != nums[i+1]) {
        //         return nums[i];
        //         // break;
        //     }
        // }
        // return nums[nums.length-1];

        // Approach 3 : Bit Manipulation
        
        int ans=0; //since XOR with 0 returns same number 
        for(int i=0; i<nums.length; i++){
            ans ^= nums[i];  // ans = (ans) XOR (array element at i) 
        }
        return ans;    
    
    }
}
