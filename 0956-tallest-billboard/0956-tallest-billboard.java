class Solution {
    //Memorization DP
    public static int tallestBillboard(int[] rods) {
        int[][] dp = new int[rods.length][10001];
        for(int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        //-5000 => 0
        //sum => sum + 5000
        return f(rods, 0, 0, dp);
    }

    public static int f(int[] rods, int index, int pre, int[][] dp) {
        if(index == rods.length) {
            return pre == 0 ? 0 : Integer.MIN_VALUE;
        }
        if(dp[index][pre + 5000] != -1) {
            return dp[index][pre + 5000];
        }
        dp[index][pre + 5000] = Integer.MIN_VALUE;
        int add = f(rods, index + 1, pre + rods[index], dp);
        if(add != Integer.MIN_VALUE) {
            dp[index][pre + 5000] = Math.max(dp[index][pre + 5000], add + rods[index]);
        }
        dp[index][pre + 5000] = Math.max(dp[index][pre + 5000], 
                        f(rods, index + 1, pre - rods[index], dp));
        dp[index][pre + 5000] = Math.max(dp[index][pre + 5000],
                        f(rods, index + 1, pre, dp));
        return dp[index][pre + 5000];
    }

    //brute force 1: O(3^N)
    // public static int tallestBillboard2(int[] rods) {
    //     return f(rods, 0, 0);
    // }

    // public static int f(int[] rods, int index, int pre) {
    //     if(index == rods.length) {
    //         return pre == 0 ? 0 : -1;
    //     }
    //     int add = f(rods, index + 1, pre + rods[index]);
    //     if(add != - 1) {
    //         add += rods[index];
    //     }
    //     int sub = f(rods, index + 1, pre - rods[index]);
    //     int ignore = f(rods, index + 1, pre);
    //     return Math.max(Math.max(add, sub), ignore);
    // }

    //Brute Force 2 : O(sum * 2^N * (num of arr which sum = i) * (N*sum))
    // ~= O(sum^2 * 2^N)
//     public static int tallestBillboard3(int[] rods) {
//         int sum = 0;
//         for(int i: rods) {
//             sum += i;
//         }

//         List<List<Integer>> sumEqualsToI = null;
//         for(int i = sum; i > 0; i--) {
//             if((i & 1) == 0) {
//                 sumEqualsToI = new ArrayList<>();
//                 f(rods, sumEqualsToI, 0, new ArrayList<>(), i, 0);
//                 if(sumEqualsToI.size() != 0) {
//                     for(List<Integer> nums: sumEqualsToI) {
//                         int[] arr = new int[nums.size()];
//                         for(int j = 0; j < nums.size(); j++) {
//                             arr[j] = nums.get(j);
//                         }
//                         if(canDivide(arr, i)) {
//                             return i >> 1;
//                         }
//                     }
//                 }
//             }
//         }
//         return 0;
//     }

//     public static void f(int[] rods, List<List<Integer>> ans, int pre,
//                          List<Integer> path, int target, int index) {
//         if(pre == target) {
//             ans.add(new ArrayList<>(path));
//             return;
//         }
//         if(index == rods.length || pre > target) {
//             return;
//         }
//         path.add(rods[index]);
//         f(rods, ans, pre + rods[index], path, target, index + 1);
//         path.remove(path.size() - 1);

//         f(rods, ans, pre, path, target, index + 1);
//     }

//     public static boolean canDivide(int[] nums, int sum) {
//         int N = nums.length;
//         if(N == 1) {
//             return false;
//         }
//         if(N == 2) {
//             return nums[0] == (sum >> 1);
//         }
//         boolean[] dp = new boolean[(sum >> 1) + 1];
//         dp[nums[0]] = true;
//         for(int i = 1; i < N; i++) {
//             for(int j = sum >> 1; j >= nums[i]; j--) {
//                 if(j - nums[i] >= 0) {
//                     dp[j] |= dp[j - nums[i]];
//                 }
//             }
//             dp[0] = dp[0] || nums[i] == 0;
//         }
//         return dp[(sum >> 1)];
//     }
}